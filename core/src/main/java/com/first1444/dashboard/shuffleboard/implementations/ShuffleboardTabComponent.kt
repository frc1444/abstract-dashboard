package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.SendableHelper
import com.first1444.dashboard.shuffleboard.ActiveShuffleboardContainer
import com.first1444.dashboard.shuffleboard.ShuffleboardComponent

object ShuffleboardTabComponent : ShuffleboardComponent<ActiveShuffleboardContainer> {
    override fun init(title: String, parentDashboard: BasicDashboard, metadataDashboard: BasicDashboard): ActiveShuffleboardContainer {
        val dashboard = parentDashboard.getSubDashboard(title)
        SendableHelper(dashboard).setType("ShuffleboardTab")
        return DefaultShuffleboardContainer(title, dashboard, metadataDashboard)
    }
}
