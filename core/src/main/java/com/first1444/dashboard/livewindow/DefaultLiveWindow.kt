package com.first1444.dashboard.livewindow

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.SendableDashboard

class DefaultLiveWindow(
        rootDashboard: BasicDashboard
) : ActiveLiveWindow {
    private val dashboard = rootDashboard.getSubDashboard("LiveWindow")
    private val statusDashboard = dashboard.getSubDashboard(".status")
    private val enabledEntry = statusDashboard["LW Enabled"]

    override var isEnabled: Boolean = false
        set(value) {
            field = value
            enabledEntry.strictSetter.setBoolean(value)
        }
    override val sendableDashboard: SendableDashboard
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val title: String = "Live Window"

    override fun update() {
    }

    override fun onRemove() {
    }

}
