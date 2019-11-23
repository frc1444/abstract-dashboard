package com.first1444.dashboard.shuffleboard

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.Sendable
import com.first1444.dashboard.advanced.SendableHelper

class SendableComponent<T : ActiveComponent>(
        private val sendable: Sendable<T>
) : ShuffleboardComponent<T> {
    override fun init(title: String, parentDashboard: BasicDashboard, metadataDashboard: BasicDashboard): T {
        val dashboard = parentDashboard.getSubDashboard(title)
        SendableHelper(dashboard)
                .setName(title)
        return sendable.init(title, dashboard)
    }

}
