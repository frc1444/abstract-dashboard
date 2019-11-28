package com.first1444.dashboard.bundle

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.AdvancedDashboard
import com.first1444.dashboard.livewindow.LiveWindow
import com.first1444.dashboard.shuffleboard.Shuffleboard
import com.first1444.dashboard.smartdashboard.SmartDashboard

interface DashboardBundle {
    val rootDashboard: BasicDashboard

    val shuffleboard: Shuffleboard
    val smartDashboard: SmartDashboard
    val liveWindow: LiveWindow
}
