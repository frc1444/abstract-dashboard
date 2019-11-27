package com.first1444.dashboard.bundle

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.AdvancedDashboard
import com.first1444.dashboard.advanced.BasicAdvancedDashboard
import com.first1444.dashboard.livewindow.DefaultLiveWindow
import com.first1444.dashboard.livewindow.LiveWindow
import com.first1444.dashboard.shuffleboard.implementations.DefaultShuffleboard

class DefaultDashboardBundle(
        override val rootDashboard: BasicDashboard
) : ActiveDashboardBundle {
    override val title: String = "Default Dashboard Bundle"

    override val shuffleboard = DefaultShuffleboard(rootDashboard)

    override val smartDashboardBasic: BasicDashboard = rootDashboard.getSubDashboard("SmartDashboard")
    override val smartDashboard = BasicAdvancedDashboard("Smart Dashboard", smartDashboardBasic)

    override val liveWindow: LiveWindow = DefaultLiveWindow(rootDashboard)

    override fun update() {
        shuffleboard.update()
        smartDashboard.update()
    }

    override fun onRemove() {
        shuffleboard.onRemove()
        smartDashboard.onRemove()
    }
}
