package com.first1444.dashboard.bundle

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.AdvancedDashboard
import com.first1444.dashboard.livewindow.LiveWindow
import com.first1444.dashboard.shuffleboard.Shuffleboard

interface DashboardBundle {
    val rootDashboard: BasicDashboard

    val shuffleboard: Shuffleboard

    val smartDashboard: AdvancedDashboard
    val smartDashboardBasic: BasicDashboard

    val liveWindow: LiveWindow
}
