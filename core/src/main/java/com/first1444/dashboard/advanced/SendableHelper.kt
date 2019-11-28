package com.first1444.dashboard.advanced

import com.first1444.dashboard.BasicDashboard

open class SendableHelper(
        private val dashboard: BasicDashboard
) {
    @set:JvmSynthetic
    var name: String
        get() = dashboard[".name"].getter.getString("")
        set(value) { dashboard[".name"].strictSetter.setString(value) }

    fun setName(value: String): SendableHelper {
        name = value
        return this
    }

    /**
     * Sets the dashboard type. AKA the SmartDashboard type
     */
    @set:JvmSynthetic
    var type: String
        get() = dashboard[".type"].getter.getString("")
        set(value) { dashboard[".type"].strictSetter.setString(value) }

    fun setType(value: String): SendableHelper {
        type = value
        return this
    }

    @set:JvmSynthetic
    var isActuator: Boolean
        get() = dashboard[".actuator"].getter.getBoolean(false)
        set(value) { dashboard[".actuator"].strictSetter.setBoolean(value) }

    fun setActuator(value: Boolean): SendableHelper {
        isActuator = value
        return this
    }

    @set:JvmSynthetic
    var isControllable: Boolean
        get() = dashboard[".controllable"].getter.getBoolean(false)
        set(value) { dashboard[".controllable"].strictSetter.setBoolean(value) }

    /**
     * This is primarily used for actuators. It is not clearly defined what Shuffleboard, SmartDashboard, or LiveWindow components use this but it is
     * not necessary to set this for every component. The general rule is that if it's an actuator, set this to true when it can be controlled, set it to false
     * when you stop checking for new control input.
     */
    fun setControllable(value: Boolean): SendableHelper {
        isControllable = value
        return this
    }
}
