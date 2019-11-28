package com.first1444.dashboard.advanced

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.enable.EnabledProvider

class ActuatorSendable
/**
 * @param sendable The [Sendable] that will be used
 * @param enabledProvider The [EnabledProvider] that that enables or disabled [sendable]
 * @param reportActuator true to set `.actuator` to true, false to leave unspecified.
 */
constructor(
        private val sendable: Sendable<*>,
        private val enabledProvider: EnabledProvider,
        private val reportActuator: Boolean
) : Sendable<ActiveComponent> {
    override fun init(title: String, dashboard: BasicDashboard): ActiveComponent {
        if(reportActuator){
            SendableHelper(dashboard).setActuator(true)
        }
        return object : ActiveComponent {
            override val title: String get() = title

            private var activeComponent: ActiveComponent? = null

            override fun update() {
                var activeComponent = this.activeComponent
                if(enabledProvider.isEnabled){
                    if(activeComponent == null){
                        activeComponent = sendable.init(title, dashboard)
                        this.activeComponent = activeComponent
                    }
                    activeComponent.update()
                } else {
                    if(activeComponent != null){
                        activeComponent.onRemove()
                        this.activeComponent = null
                    }
                }
            }

            override fun onRemove() {
                activeComponent?.onRemove()
                activeComponent = null
            }

        }
    }
}

