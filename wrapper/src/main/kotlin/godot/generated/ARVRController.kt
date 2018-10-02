@file:Suppress("unused", "ClassName", "EnumEntryName", "FunctionName", "SpellCheckingInspection", "PARAMETER_NAME_CHANGED_ON_OVERRIDE", "UnusedImport", "PackageDirectoryMismatch")
package godot

import godot.gdnative.*
import godot.core.*
import godot.icalls.*
import kotlinx.cinterop.*


// NOTE: THIS FILE IS AUTO GENERATED FROM JSON API CONFIG


open class ARVRController : Spatial {
    constructor() : super("ARVRController")
    constructor(variant: Variant) : super(variant)
    internal constructor(mem: COpaquePointer) : super(mem)
    internal constructor(name: String) : super(name)


    // Enums 



    // Signals
    class Signal {
        companion object {
            const val BUTTON_RELEASE: String = "button_release"
            const val BUTTON_PRESSED: String = "button_pressed"
        }
    }


    companion object {
        infix fun from(other: Spatial): ARVRController = ARVRController("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Node): ARVRController = ARVRController("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Object): ARVRController = ARVRController("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Variant): ARVRController = fromVariant(ARVRController(""), other)


        // Constants


    }


    // Properties
    open var controllerId: Int
        get() = _icall_Int(getControllerIdMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Int(setControllerIdMethodBind, this.rawMemory, value)


    open var rumble: Float
        get() = _icall_Float(getRumbleMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Float(setRumbleMethodBind, this.rawMemory, value)




    // Methods
    private val setControllerIdMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "set_controller_id") }
    open fun setControllerId(controllerId: Int) {
        _icall_Unit_Int(setControllerIdMethodBind, this.rawMemory, controllerId)
    }


    private val getControllerIdMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "get_controller_id") }
    open fun getControllerId(): Int {
        return _icall_Int(getControllerIdMethodBind, this.rawMemory)
    }


    private val getControllerNameMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "get_controller_name") }
    open fun getControllerName(): String {
        return _icall_String(getControllerNameMethodBind, this.rawMemory)
    }


    private val getJoystickIdMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "get_joystick_id") }
    open fun getJoystickId(): Int {
        return _icall_Int(getJoystickIdMethodBind, this.rawMemory)
    }


    private val isButtonPressedMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "is_button_pressed") }
    open fun isButtonPressed(button: Int): Int {
        return _icall_Int_Int(isButtonPressedMethodBind, this.rawMemory, button)
    }


    private val getJoystickAxisMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "get_joystick_axis") }
    open fun getJoystickAxis(axis: Int): Float {
        return _icall_Float_Int(getJoystickAxisMethodBind, this.rawMemory, axis)
    }


    private val getIsActiveMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "get_is_active") }
    open fun getIsActive(): Boolean {
        return _icall_Boolean(getIsActiveMethodBind, this.rawMemory)
    }


    private val getHandMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "get_hand") }
    open fun getHand(): ARVRPositionalTracker.TrackerHand {
        return ARVRPositionalTracker.TrackerHand.fromInt(_icall_Int(getHandMethodBind, this.rawMemory))
    }


    private val getRumbleMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "get_rumble") }
    open fun getRumble(): Float {
        return _icall_Float(getRumbleMethodBind, this.rawMemory)
    }


    private val setRumbleMethodBind: CPointer<godot_method_bind> by lazy { getMB("ARVRController", "set_rumble") }
    open fun setRumble(rumble: Float) {
        _icall_Unit_Float(setRumbleMethodBind, this.rawMemory, rumble)
    }


}
