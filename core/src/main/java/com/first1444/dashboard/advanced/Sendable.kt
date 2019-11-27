package com.first1444.dashboard.advanced

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard

interface Sendable<out T : ActiveComponent> {
    /**
     * It is possible that [dashboard] will already have some of its properties filled in. This may be because of persistent data
     * or because of this instance being wrapped in a class such as [ActuatorSendable] which will call [ActiveComponent.onRemove] on the returned
     * [ActiveComponent] when temporarily stopping updates to the data that this [Sendable] represents
     *
     * The caller is responsible for creating [dashboard] and is responsible for removing [dashboard] after [ActiveComponent.onRemove] is called, if the caller wants to.
     * @param title The title. [ActiveComponent.title] should be set to this
     * @param dashboard The dashboard to apply properties to
     * @return An [ActiveComponent] that will be updated and eventually removed
     */
    fun init(title: String, dashboard: BasicDashboard): T
}
