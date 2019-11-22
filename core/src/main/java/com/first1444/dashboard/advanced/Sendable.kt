package com.first1444.dashboard.advanced

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard

interface Sendable {
    fun init(dashboard: BasicDashboard): ActiveComponent
}
