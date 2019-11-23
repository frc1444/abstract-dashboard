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
    var dashboardType: String
        get() = dashboard[".type"].getter.getString("")
        set(value) { dashboard[".type"].strictSetter.setString(value) }

    fun setDashboardType(value: String): SendableHelper {
        dashboardType = value
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

    fun setControllable(value: Boolean): SendableHelper {
        isControllable = value
        return this
    }
}
