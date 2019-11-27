package com.first1444.dashboard.shuffleboard

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.value.ValueProperty
import com.first1444.dashboard.value.implementations.PropertyActiveComponent

class PropertyComponent(
        private val valueProperty: ValueProperty
) : ShuffleboardComponent<ActiveComponent> {
    override fun init(title: String, parentDashboard: BasicDashboard, metadataDashboard: BasicDashboard): ActiveComponent {
        val entry = parentDashboard[title]
        return PropertyActiveComponent(title, entry, valueProperty)
    }
}
