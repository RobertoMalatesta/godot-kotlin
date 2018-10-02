@file:Suppress("unused", "ClassName", "EnumEntryName", "FunctionName", "SpellCheckingInspection", "PARAMETER_NAME_CHANGED_ON_OVERRIDE", "UnusedImport", "PackageDirectoryMismatch")
package godot

import godot.gdnative.*
import godot.core.*
import godot.icalls.*
import kotlinx.cinterop.*


// NOTE: THIS FILE IS AUTO GENERATED FROM JSON API CONFIG


open class Timer : Node {
    constructor() : super("Timer")
    constructor(variant: Variant) : super(variant)
    internal constructor(mem: COpaquePointer) : super(mem)
    internal constructor(name: String) : super(name)


    // Enums 

    enum class TimerProcessMode(val id: Int) {
        TIMER_PROCESS_PHYSICS(0),
        TIMER_PROCESS_IDLE(1),
        ;

        companion object {
            fun fromInt(value: Int) = values().single { it.id == value }
        }
    }


    // Signals
    class Signal {
        companion object {
            const val TIMEOUT: String = "timeout"
        }
    }


    companion object {
        infix fun from(other: Node): Timer = Timer("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Object): Timer = Timer("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Variant): Timer = fromVariant(Timer(""), other)


        // Constants
        const val TIMER_PROCESS_PHYSICS: Int = 0
        const val TIMER_PROCESS_IDLE: Int = 1


    }


    // Properties
    open var processMode: Int
        get() = _icall_Int(getTimerProcessModeMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Int(setTimerProcessModeMethodBind, this.rawMemory, value)


    open var waitTime: Float
        get() = _icall_Float(getWaitTimeMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Float(setWaitTimeMethodBind, this.rawMemory, value)


    open var oneShot: Boolean
        get() = _icall_Boolean(isOneShotMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Boolean(setOneShotMethodBind, this.rawMemory, value)


    open var autostart: Boolean
        get() = _icall_Boolean(hasAutostartMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Boolean(setAutostartMethodBind, this.rawMemory, value)


    open var paused: Boolean
        get() = _icall_Boolean(isPausedMethodBind, this.rawMemory)
        set(value) = _icall_Unit_Boolean(setPausedMethodBind, this.rawMemory, value)


    open val timeLeft: Float
        get() = _icall_Float(getTimeLeftMethodBind, this.rawMemory)




    // Methods
    private val setWaitTimeMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "set_wait_time") }
    open fun setWaitTime(timeSec: Float) {
        _icall_Unit_Float(setWaitTimeMethodBind, this.rawMemory, timeSec)
    }


    private val getWaitTimeMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "get_wait_time") }
    open fun getWaitTime(): Float {
        return _icall_Float(getWaitTimeMethodBind, this.rawMemory)
    }


    private val setOneShotMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "set_one_shot") }
    open fun setOneShot(enable: Boolean) {
        _icall_Unit_Boolean(setOneShotMethodBind, this.rawMemory, enable)
    }


    private val isOneShotMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "is_one_shot") }
    open fun isOneShot(): Boolean {
        return _icall_Boolean(isOneShotMethodBind, this.rawMemory)
    }


    private val setAutostartMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "set_autostart") }
    open fun setAutostart(enable: Boolean) {
        _icall_Unit_Boolean(setAutostartMethodBind, this.rawMemory, enable)
    }


    private val hasAutostartMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "has_autostart") }
    open fun hasAutostart(): Boolean {
        return _icall_Boolean(hasAutostartMethodBind, this.rawMemory)
    }


    private val startMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "start") }
    open fun start(timeSec: Float = -1f) {
        _icall_Unit_Float(startMethodBind, this.rawMemory, timeSec)
    }


    private val stopMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "stop") }
    open fun stop() {
        _icall_Unit(stopMethodBind, this.rawMemory)
    }


    private val setPausedMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "set_paused") }
    open fun setPaused(paused: Boolean) {
        _icall_Unit_Boolean(setPausedMethodBind, this.rawMemory, paused)
    }


    private val isPausedMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "is_paused") }
    open fun isPaused(): Boolean {
        return _icall_Boolean(isPausedMethodBind, this.rawMemory)
    }


    private val isStoppedMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "is_stopped") }
    open fun isStopped(): Boolean {
        return _icall_Boolean(isStoppedMethodBind, this.rawMemory)
    }


    private val getTimeLeftMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "get_time_left") }
    open fun getTimeLeft(): Float {
        return _icall_Float(getTimeLeftMethodBind, this.rawMemory)
    }


    private val setTimerProcessModeMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "set_timer_process_mode") }
    open fun setTimerProcessMode(mode: Int) {
        _icall_Unit_Int(setTimerProcessModeMethodBind, this.rawMemory, mode)
    }


    private val getTimerProcessModeMethodBind: CPointer<godot_method_bind> by lazy { getMB("Timer", "get_timer_process_mode") }
    open fun getTimerProcessMode(): Timer.TimerProcessMode {
        return Timer.TimerProcessMode.fromInt(_icall_Int(getTimerProcessModeMethodBind, this.rawMemory))
    }


}
