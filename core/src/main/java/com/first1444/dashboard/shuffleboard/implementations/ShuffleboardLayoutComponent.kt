package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.shuffleboard.MetadataEditor
import com.first1444.dashboard.shuffleboard.ShuffleboardComponent
import com.first1444.dashboard.shuffleboard.ShuffleboardContainer

/**
 * When initialized, creates an [ActiveComponent] that contains the current components that have been added
 */
class ShuffleboardLayout : ShuffleboardContainer, ShuffleboardComponent {
    private class Component(
            val title: String,
            val component: ShuffleboardComponent,
            val metadataEditor: MetadataEditor
    )
    private val components = ArrayList<Component>()

    override fun addComponent(title: String, component: ShuffleboardComponent, metadataEditor: MetadataEditor): ActiveComponent {
        components.add(Component(title, component, metadataEditor))
    }

    override fun init(title: String, parentDashboard: BasicDashboard, metadataDashboard: BasicDashboard): ActiveComponent {
        val dashboard = parentDashboard.getSubDashboard(title)
        for(component in components){
            component.component.init(component.title, dashboard, )
        }
    }

}
