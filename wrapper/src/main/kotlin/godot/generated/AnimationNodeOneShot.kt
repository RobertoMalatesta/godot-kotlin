@file:Suppress("unused", "ClassName", "EnumEntryName", "FunctionName", "SpellCheckingInspection", "PARAMETER_NAME_CHANGED_ON_OVERRIDE", "UnusedImport", "PackageDirectoryMismatch")
package godot

import godot.gdnative.*
import godot.core.*
import godot.icalls.*
import kotlinx.cinterop.*


// NOTE: THIS FILE IS AUTO GENERATED FROM JSON API CONFIG


open class AnimationNodeOneShot : AnimationNode {
    constructor() : super("AnimationNodeOneShot")
    constructor(variant: Variant) : super(variant)
    internal constructor(mem: COpaquePointer) : super(mem)
    internal constructor(name: String) : super(name)


    // Enums 

    enum class MixMode(val id: Int) {
        MIX_MODE_BLEND(0),
        MIX_MODE_ADD(1),
        ;

        companion object {
            fun fromInt(value: Int) = values().single { it.id == value }
        }
    }


    // Signals
    class Signal {
        companion object {
        }
    }


    companion object {
        infix fun from(other: AnimationNode): AnimationNodeOneShot = AnimationNodeOneShot("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Resource): AnimationNodeOneShot = AnimationNodeOneShot("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Reference): AnimationNodeOneShot = AnimationNodeOneShot("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Object): AnimationNodeOneShot = AnimationNodeOneShot("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Variant): AnimationNodeOneShot = fromVariant(AnimationNodeOneShot(""), other)


        // Constants
        const val MIX_MODE_BLEND: Int = 0
        const val MIX_MODE_ADD: Int = 1


    }


    // Properties
    open var fadeinTime: Float
        get() = _icall_Float(getFadeinTimeMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Float(setFadeinTimeMethodBind, this.rawMemory, value)


    open var fadeoutTime: Float
        get() = _icall_Float(getFadeoutTimeMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Float(setFadeoutTimeMethodBind, this.rawMemory, value)


    open var autorestart: Boolean
        get() = _icall_Boolean(hasAutorestartMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Boolean(setAutorestartMethodBind, this.rawMemory, value)


    open var autorestartDelay: Float
        get() = _icall_Float(getAutorestartDelayMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Float(setAutorestartDelayMethodBind, this.rawMemory, value)


    open var autorestartRandomDelay: Float
        get() = _icall_Float(getAutorestartRandomDelayMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Float(setAutorestartRandomDelayMethodBind, this.rawMemory, value)


    open var sync: Boolean
        get() = _icall_Boolean(isUsingSyncMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Boolean(setUseSyncMethodBind, this.rawMemory, value)




    // Methods
    private val setFadeinTimeMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "set_fadein_time") }
    open fun setFadeinTime(time: Float) {
        _icall_Unit_Float(setFadeinTimeMethodBind, this.rawMemory, time)
    }


    private val getFadeinTimeMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "get_fadein_time") }
    open fun getFadeinTime(): Float {
        return _icall_Float(getFadeinTimeMethodBind, this.rawMemory)
    }


    private val setFadeoutTimeMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "set_fadeout_time") }
    open fun setFadeoutTime(time: Float) {
        _icall_Unit_Float(setFadeoutTimeMethodBind, this.rawMemory, time)
    }


    private val getFadeoutTimeMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "get_fadeout_time") }
    open fun getFadeoutTime(): Float {
        return _icall_Float(getFadeoutTimeMethodBind, this.rawMemory)
    }


    private val setAutorestartMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "set_autorestart") }
    open fun setAutorestart(enable: Boolean) {
        _icall_Unit_Boolean(setAutorestartMethodBind, this.rawMemory, enable)
    }


    private val hasAutorestartMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "has_autorestart") }
    open fun hasAutorestart(): Boolean {
        return _icall_Boolean(hasAutorestartMethodBind, this.rawMemory)
    }


    private val setAutorestartDelayMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "set_autorestart_delay") }
    open fun setAutorestartDelay(enable: Float) {
        _icall_Unit_Float(setAutorestartDelayMethodBind, this.rawMemory, enable)
    }


    private val getAutorestartDelayMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "get_autorestart_delay") }
    open fun getAutorestartDelay(): Float {
        return _icall_Float(getAutorestartDelayMethodBind, this.rawMemory)
    }


    private val setAutorestartRandomDelayMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "set_autorestart_random_delay") }
    open fun setAutorestartRandomDelay(enable: Float) {
        _icall_Unit_Float(setAutorestartRandomDelayMethodBind, this.rawMemory, enable)
    }


    private val getAutorestartRandomDelayMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "get_autorestart_random_delay") }
    open fun getAutorestartRandomDelay(): Float {
        return _icall_Float(getAutorestartRandomDelayMethodBind, this.rawMemory)
    }


    private val setMixModeMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "set_mix_mode") }
    open fun setMixMode(mode: Int) {
        _icall_Unit_Int(setMixModeMethodBind, this.rawMemory, mode)
    }


    private val getMixModeMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "get_mix_mode") }
    open fun getMixMode(): AnimationNodeOneShot.MixMode {
        return AnimationNodeOneShot.MixMode.fromInt(_icall_Int(getMixModeMethodBind, this.rawMemory))
    }


    private val startMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "start") }
    open fun start() {
        _icall_Unit(startMethodBind, this.rawMemory)
    }


    private val stopMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "stop") }
    open fun stop() {
        _icall_Unit(stopMethodBind, this.rawMemory)
    }


    private val isActiveMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "is_active") }
    open fun isActive(): Boolean {
        return _icall_Boolean(isActiveMethodBind, this.rawMemory)
    }


    private val setUseSyncMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "set_use_sync") }
    open fun setUseSync(enable: Boolean) {
        _icall_Unit_Boolean(setUseSyncMethodBind, this.rawMemory, enable)
    }


    private val isUsingSyncMethodBind: CPointer<godot_method_bind> by lazy { getMB("AnimationNodeOneShot", "is_using_sync") }
    open fun isUsingSync(): Boolean {
        return _icall_Boolean(isUsingSyncMethodBind, this.rawMemory)
    }


}
