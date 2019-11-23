package com.first1444.dashboard.advanced

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard

interface Sendable<out T : ActiveComponent> {
    /**
     * @param title The title. [ActiveComponent.title] should be set to this
     * @param dashboard The dashboard to apply properties to
     * @return An [ActiveComponent] that will be updated and eventually removed
     */
    fun init(title: String, dashboard: BasicDashboard): T
}
