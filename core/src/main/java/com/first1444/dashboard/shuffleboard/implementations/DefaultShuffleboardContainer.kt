package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.shuffleboard.ActiveShuffleboardContainer
import com.first1444.dashboard.shuffleboard.MetadataEditor
import com.first1444.dashboard.shuffleboard.ShuffleboardComponent

class ShuffleboardLayoutContainer(
        override val title: String,
        private val dashboard: BasicDashboard,
        private val metadataDashboard: BasicDashboard
) : ActiveShuffleboardContainer {
    private var removed = false
    private val components = ArrayList<ActiveComponent>()


    private fun checkRemoved(){
        check(!removed) { "Cannot use this because it has been removed!" }
    }

    override fun remove(title: String) {
        checkRemoved()
    }

    override fun remove(component: ActiveComponent) {
        checkRemoved()
    }


    override fun update() {
        checkRemoved()
        for(component in components){
            component.update()
        }
    }

    override fun onRemove() {
        removed = true
        for(component in components){
            component.onRemove()
        }
    }


    override fun <T : ActiveComponent>addComponent(title: String, component: ShuffleboardComponent<T>, metadataEditor: MetadataEditor): T {
        checkRemoved()
        val componentMetadata = metadataDashboard.getSubDashboard(title)
        val r = component.init(title, dashboard, componentMetadata)
        components.add(r)
        return r
    }

}
