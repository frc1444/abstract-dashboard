package com.first1444.dashboard.advanced

import com.first1444.dashboard.BasicDashboard

interface SendableBuilder {
    var dashboardType: String
    var isActuator: Boolean
    val dashboard: BasicDashboard

    var safeState: Runnable?
    var updater: Runnable?
}
