package kotlin.godot.core

import godot.godot_transform2d
import kotlinx.cinterop.*
import platform.posix.perror
import kotlin.math.acos
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin


class Transform2D: CoreType {
    // Warning #1: basis of Transform2D is stored differently from Basis. In terms of elements array, the basis matrix looks like "on paper":
    // M = (elements[0][0] elements[1][0])
    //     (elements[0][1] elements[1][1])
    // This is such that the columns, which can be interpreted as basis vectors of the coordinate system "painted" on the object, can be accessed as elements[i].
    // Note that this is the opposite of the indices in mathematical texts, meaning: $M_{12}$ in a math book corresponds to elements[1][0] here.
    // This requires additional care when working with explicit indices.
    // See https://en.wikipedia.org/wiki/Row-_and_column-major_order for further reading.

    // Warning #2: 2D be aware that unlike 3D code, 2D code uses a left-handed coordinate system: Y-axis points down,
    // and angle is measure from +X to +Y in a clockwise-fashion.

    var elements: Array<Vector2> =
            arrayOf(Vector2(), Vector2(), Vector2())

    override fun getRawMemory(memScope: MemScope): COpaquePointer {
        return cValuesOf(elements[0][0], elements[0][1], elements[1][0], elements[1][1], elements[2][0], elements[2][1]).getPointer(memScope)
    }

    override fun setRawMemory(mem: COpaquePointer) {
        val arr = mem.reinterpret<FloatVar>()
        elements[0][0] = arr[0]
        elements[0][1] = arr[1]
        elements[1][0] = arr[2]
        elements[1][1] = arr[3]
        elements[2][0] = arr[4]
        elements[2][1] = arr[5]
    }

    constructor(xx: Number, xy: Number, yx: Number, yy: Number, ox: Number, oy: Number) {
        elements[0][0] = xx.toFloat()
        elements[0][1] = xy.toFloat()
        elements[1][0] = yx.toFloat()
        elements[1][1] = yy.toFloat()
        elements[2][0] = ox.toFloat()
        elements[2][1] = oy.toFloat()
    }

    constructor(p_rot: Number, p_pos: Vector2) {
        val cr = cos(p_rot.toFloat())
        val sr = sin(p_rot.toFloat())
        elements[0][0] = cr
        elements[0][1] = sr
        elements[1][0] = -sr
        elements[1][1] = cr
        elements[2] = p_pos
    }

    constructor() {
        elements[0][0] = 1f
        elements[1][1] = 1f
    }

    internal constructor(native: CValue<godot_transform2d>) {
        memScoped {
            this@Transform2D.setRawMemory(native.ptr)
        }
    }

    internal constructor(mem: COpaquePointer) {
        this.setRawMemory(mem)
    }

    fun tdotx(v: Vector2): Float =
            elements[0][0] * v.x + elements[1][0] * v.y

    fun tdoty(v: Vector2): Float =
            elements[0][1] * v.x + elements[1][1] * v.y

    operator fun get(n: Int): Vector2 =
            elements[n]

    fun getAxis(p_axis: Int) =
            elements[p_axis]

    fun setAxis(p_axis: Int, p_vec: Vector2) {
        elements[p_axis] = p_vec
    }

    fun getOrigin(): Vector2 =
            elements[2]

    fun setOrigin(p_origin: Vector2) {
        elements[2] = p_origin
    }

    fun basisXform(v: Vector2): Vector2 =
            Vector2(tdotx(v), tdoty(v))

    fun basisXformInv(v: Vector2): Vector2 =
            Vector2(elements[0].dot(v), elements[1].dot(v))

    fun xform(v: Vector2): Vector2 =
            Vector2(tdotx(v), tdoty(v)) + elements[2]

    fun xformInv(p_vec: Vector2): Vector2 {
        val v = p_vec - elements[2]
        return Vector2(elements[0].dot(v), elements[1].dot(v))
    }

    fun xform(p_rect: Rect2): Rect2 {
        val x = elements[0] * p_rect.size.x
        val y = elements[1] * p_rect.size.y
        val pos = xform(p_rect.pos)

        val new_rect = Rect2()
        new_rect.pos = pos
        new_rect.expandTo(pos + x)
        new_rect.expandTo(pos + y)
        new_rect.expandTo(pos + x + y)
        return new_rect
    }

    fun setRotationAndScale(p_rot: Float, p_scale: Vector2) {
        elements[0][0]=cos(p_rot)*p_scale.x
        elements[1][1]=cos(p_rot)*p_scale.y
        elements[1][0]=-sin(p_rot)*p_scale.y
        elements[0][1]=sin(p_rot)*p_scale.x
    }

    fun xformInv(p_rect: Rect2): Rect2 {
        val ends = arrayOf(xformInv(p_rect.pos),
                xformInv(Vector2(p_rect.pos.x, p_rect.pos.y + p_rect.size.y)),
                xformInv(Vector2(p_rect.pos.x + p_rect.size.x, p_rect.pos.y + p_rect.size.y)),
                xformInv(Vector2(p_rect.pos.x + p_rect.size.x, p_rect.pos.y)))

        val new_rect = Rect2()
        new_rect.pos=ends[0]
        new_rect.expandTo(ends[1])
        new_rect.expandTo(ends[2])
        new_rect.expandTo(ends[3])

        return new_rect
    }

    fun invert() {
        elements[0][1] = elements[1][0].also { elements[1][0] = elements[0][1] }
        elements[2] = basisXform(-elements[2])
    }

    fun inverse(): Transform2D {
        val inv = this
        inv.invert()
        return inv
    }

    fun affineInvert() {
        val det = basisDeterminant()
        if (det == 0f) { perror("det == 0\n"); return }
        val idet = - 1f / det
        elements[0][0] = elements[1][1].also { elements[1][1] = elements[0][0] }
        elements[0] *= Vector2(idet,-idet)
        elements[1] *= Vector2(-idet,idet)

        elements[2] = basisXform(-elements[2])
    }

    fun affineInverse(): Transform2D {
        val inv = this
        inv.affineInvert()
        return inv
    }

    fun rotate(p_phi: Float) {
        val new_t = Transform2D(p_phi,Vector2()) * this
        this.elements = new_t.elements
    }

    fun getRotation(): Float {
        val det = basisDeterminant()
        val m = orthonormalized()
        if (det < 0) {
            m.scaleBasis(Vector2(-1, -1))
        }
        return atan2(m[0].y, m[0].x)
    }

    fun setRotation(p_rot: Float) {
        val cr = cos(p_rot)
        val sr = sin(p_rot)
        elements[0][0] = cr
        elements[0][1] = sr
        elements[1][0] = -sr
        elements[1][1] = cr
    }

    fun getScale(): Vector2 {
        val detSign: Float = if (basisDeterminant() > 0f) 1f else -1f
        return detSign * Vector2(elements[0].length(), elements[1].length())
    }

    fun scale(p_scale: Vector2) {
        scaleBasis(p_scale)
        elements[2] *= p_scale
    }

    fun scaleBasis(p_scale: Vector2) {
        elements[0][0] *= p_scale.x
        elements[0][1] *= p_scale.y
        elements[1][0] *= p_scale.x
        elements[1][1] *= p_scale.y
    }

    fun translate(p_translation: Vector2) {
        elements[2] += basisXform(p_translation)
    }

    fun translate(p_tx: Float, p_ty: Float) =
            translate(Vector2(p_tx, p_ty))

    fun orthonormalize() {
        var x = elements[0]
        var y = elements[1]

        x.normalize()
        y = (y - x * (x.dot(y)))
        y.normalize()

        elements[0] = x
        elements[1] = y
    }

    fun orthonormalized(): Transform2D {
        val on = this
        on.orthonormalize()
        return on
    }

    override fun equals(other: Any?): Boolean =
        when(other) {
            is Transform2D -> elements[0] == other[0] && elements[1] == other[1] && elements[2] == other[2]
            else -> false
        }

    operator fun times(other: Transform2D): Transform2D {
        val new = this
        new.elements[2] = xform(other[2])
        val x0 = tdotx(other[0])
        val x1 = tdoty(other[0])
        val y0 = tdotx(other[1])
        val y1 = tdoty(other[1])

        new[0][0] = x0
        new[0][1] = x1
        new[1][0] = y0
        new[1][1] = y1

        return new
    }

    fun scaled(p_scale: Vector2): Transform2D {
        val copy = this
        copy.scale(p_scale)
        return copy
    }

    fun basisScaled(p_scale: Vector2): Transform2D {
        val copy = this
        copy.scaleBasis(p_scale)
        return copy
    }

    fun untranslated(): Transform2D {
        val copy = this
        copy.elements[2] = Vector2()
        return copy
    }

    fun translated(p_offset: Vector2): Transform2D {
        val copy = this
        copy.translate(p_offset)
        return copy
    }

    fun rotated(p_phi: Float): Transform2D {
        val copy = this
        copy.rotate(p_phi)
        return copy
    }

    fun basisDeterminant(): Float =
            elements[0].x * elements[1].y - elements[0].y * elements[1].x

    fun interpolateWith(p_transform: Transform2D, p_c: Float): Transform2D {
        val p1 = getOrigin()
        val p2 = p_transform.getOrigin()

        val r1 = getRotation()
        val r2 = p_transform.getRotation()

        val s1 = getScale()
        val s2 = p_transform.getScale()

        val v1 = Vector2(cos(r1), sin(r1))
        val v2 = Vector2(cos(r2), sin(r2))

        var dot = v1.dot(v2)
        dot =   if (dot < -1f)
                    -1f
                else
                    if (dot > 1f)
                        1f
                    else
                        dot
        val v: Vector2

        if (dot > 0.9995)
            v = (Vector2::linearInterpolate)(v1, v2, p_c).normalized()
        else {
            val angle = p_c * acos(dot)
            val v3 = (v2 - v1 * dot).normalized()
            v = v1 * cos(angle) + v3 * sin(angle)
        }

        val res = Transform2D(atan2(v.y, v.x), (Vector2::linearInterpolate)(p1, p2, p_c))
        res.scaleBasis((Vector2::linearInterpolate)(s1, s2, p_c))
        return res
    }

    override fun toString(): String =
            elements[0].toString() + ", " + elements[1].toString() + ", " + elements[2]
}