package com.first1444.dashboard.livewindow

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.ActuatorSendable
import com.first1444.dashboard.advanced.Sendable
import com.first1444.dashboard.enable.EnabledProvider
import com.first1444.dashboard.enable.MutableEnabledProvider
import com.first1444.dashboard.enable.SimpleEnabledProvider

class DefaultLiveWindow(
        rootDashboard: BasicDashboard
) : ActiveLiveWindow {
    private val dashboard = rootDashboard.getSubDashboard("LiveWindow")
    private val statusDashboard = dashboard.getSubDashboard(".status")
    private val enabledEntry = statusDashboard["LW Enabled"]

    private val map = HashMap<Sendable<*>, Pair<ActiveComponent, MutableEnabledProvider>>()

    override val title: String = "Live Window"
    override var isEnabled: Boolean = false
        set(value) {
            field = value
            enabledEntry.strictSetter.setBoolean(value)
        }
    override fun delete(key: String): Boolean {
        val iterator = map.iterator()
        while(iterator.hasNext()){
            val (_, pair) = iterator.next()
            val (activeComponent, _) = pair
            if(activeComponent.title == key){
                iterator.remove()
                doRemove(activeComponent)
                return true
            }
        }
        return false
    }

    override fun delete(sendable: Sendable<*>): Boolean {
        val (activeComponent, _) = map.remove(sendable) ?: return false
        doRemove(activeComponent)
        return true
    }
    private fun doRemove(activeComponent: ActiveComponent){
        activeComponent.onRemove()
        dashboard.delete(activeComponent.title)
    }

    override fun add(key: String, data: Sendable<*>): Boolean {
        if(data in map){
            return false
        }
        val sendableDashboard = dashboard.getSubDashboard(key)
        val telemetryProvider = SimpleEnabledProvider(false)
        val sendable = ActuatorSendable(data, EnabledProvider { isEnabled || telemetryProvider.isEnabled }, false)
        val activeComponent = sendable.init(key, sendableDashboard)
        map[data] = Pair(activeComponent, telemetryProvider)
        return true
    }

    override fun setTelemetryEnabled(sendable: Sendable<*>, enabled: Boolean) {
        val (_, telemetryProvider) = map[sendable] ?: throw NoSuchElementException("No element found with sendable=$sendable")
        telemetryProvider.isEnabled = enabled
    }


    override fun update() {
        for((activeComponent, _) in map.values){
            activeComponent.update()
        }
    }

    override fun onRemove() {
        try {
            for((activeComponent, _) in map.values){
                activeComponent.onRemove()
            }
        } finally {
            map.clear()
        }
    }

}
