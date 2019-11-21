package com.first1444.dashboard

interface SendableBuilder {
    var dashboardType: String
    var isActuator: Boolean
    val dashboard: BasicDashboard

    var safeState: Runnable?
    var updater: Runnable?
}
