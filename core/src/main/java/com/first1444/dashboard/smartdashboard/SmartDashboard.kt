package com.first1444.dashboard.smartdashboard

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.AdvancedDashboard

interface SmartDashboard {
    val dashboard: AdvancedDashboard
    val basicDashboard: BasicDashboard
}
