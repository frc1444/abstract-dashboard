package com.first1444.dashboard.shuffleboard

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard

interface ShuffleboardComponent<out T : ActiveComponent> {
    fun init(title: String, parentDashboard: BasicDashboard, metadataDashboard: BasicDashboard): T
}
