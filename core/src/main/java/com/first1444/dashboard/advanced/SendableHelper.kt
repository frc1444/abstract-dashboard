package com.first1444.dashboard.advanced

import com.first1444.dashboard.BasicDashboard

open class SendableHelper(
        private val dashboard: BasicDashboard
) {
    var dashboardType: String
        get() = dashboard[".type"].getter.getString("")
        set(value) { dashboard[".type"].strictSetter.setString(value) }

    var isActuator: Boolean
        get() = dashboard[".actuator"].getter.getBoolean(false)
        set(value) { dashboard[".actuator"].strictSetter.setBoolean(value) }

    var isControllable: Boolean
        get() = dashboard[".controllable"].getter.getBoolean(false)
        set(value) { dashboard[".controllable"].strictSetter.setBoolean(value) }
}
