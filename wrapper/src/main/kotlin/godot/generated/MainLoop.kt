@file:Suppress("unused", "ClassName", "EnumEntryName", "FunctionName", "SpellCheckingInspection", "PARAMETER_NAME_CHANGED_ON_OVERRIDE", "UnusedImport", "PackageDirectoryMismatch")
package godot

import godot.gdnative.*
import godot.core.*
import godot.icalls.*
import kotlinx.cinterop.*


// NOTE: THIS FILE IS AUTO GENERATED FROM JSON API CONFIG


open class MainLoop : Object {
    constructor() : super("MainLoop")
    constructor(variant: Variant) : super(variant)
    internal constructor(mem: COpaquePointer) : super(mem)
    internal constructor(name: String) : super(name)


    // Enums 



    // Signals
    class Signal {
        companion object {
        }
    }


    companion object {
        infix fun from(other: Object): MainLoop = MainLoop("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Variant): MainLoop = fromVariant(MainLoop(""), other)


        // Constants
        const val NOTIFICATION_WM_MOUSE_ENTER: Int = 2
        const val NOTIFICATION_WM_MOUSE_EXIT: Int = 3
        const val NOTIFICATION_WM_FOCUS_IN: Int = 4
        const val NOTIFICATION_WM_FOCUS_OUT: Int = 5
        const val NOTIFICATION_WM_QUIT_REQUEST: Int = 6
        const val NOTIFICATION_WM_GO_BACK_REQUEST: Int = 7
        const val NOTIFICATION_WM_UNFOCUS_REQUEST: Int = 8
        const val NOTIFICATION_OS_MEMORY_WARNING: Int = 9
        const val NOTIFICATION_TRANSLATION_CHANGED: Int = 90
        const val NOTIFICATION_WM_ABOUT: Int = 91
        const val NOTIFICATION_CRASH: Int = 92


    }


    // Properties


    // Methods
    open fun _input_event(ev: InputEvent) {
    }


    open fun _input_text(text: String) {
    }


    open fun _initialize() {
    }


    open fun _iteration(delta: Float) {
    }


    open fun _idle(delta: Float) {
    }


    open fun _drop_files(files: PoolStringArray, screen: Int) {
    }


    open fun _finalize() {
    }


    private val inputEventMethodBind: CPointer<godot_method_bind> by lazy { getMB("MainLoop", "input_event") }
    open fun inputEvent(ev: InputEvent) {
        _icall_Unit_Object(inputEventMethodBind, this.rawMemory, ev)
    }


    private val inputTextMethodBind: CPointer<godot_method_bind> by lazy { getMB("MainLoop", "input_text") }
    open fun inputText(text: String) {
        _icall_Unit_String(inputTextMethodBind, this.rawMemory, text)
    }


    private val initMethodBind: CPointer<godot_method_bind> by lazy { getMB("MainLoop", "init") }
    open fun init() {
        _icall_Unit(initMethodBind, this.rawMemory)
    }


    private val iterationMethodBind: CPointer<godot_method_bind> by lazy { getMB("MainLoop", "iteration") }
    open fun iteration(delta: Float): Boolean {
        return _icall_Boolean_Float(iterationMethodBind, this.rawMemory, delta)
    }


    private val idleMethodBind: CPointer<godot_method_bind> by lazy { getMB("MainLoop", "idle") }
    open fun idle(delta: Float): Boolean {
        return _icall_Boolean_Float(idleMethodBind, this.rawMemory, delta)
    }


    private val finishMethodBind: CPointer<godot_method_bind> by lazy { getMB("MainLoop", "finish") }
    open fun finish() {
        _icall_Unit(finishMethodBind, this.rawMemory)
    }


}
