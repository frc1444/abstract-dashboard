package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.shuffleboard.ActiveShuffleboardContainer
import com.first1444.dashboard.shuffleboard.MetadataEditor
import com.first1444.dashboard.shuffleboard.ShuffleboardComponent

class DefaultShuffleboardContainer(
        override val title: String,
        private val dashboard: BasicDashboard,
        private val metadataDashboard: BasicDashboard
) : ActiveShuffleboardContainer {
    private var removed = false
    private val componentMap = HashMap<String, ActiveComponent>()
    override val components: Collection<ActiveComponent>
        get() = componentMap.values


    private fun checkRemoved(){
        check(!removed) { "Cannot use this because it has been removed!" }
    }

    override fun remove(title: String): Boolean {
        checkRemoved()
        val component = componentMap[title] ?: return false
        component.onRemove()
        componentMap.remove(title)
        return true
    }

    override fun remove(component: ActiveComponent): Boolean {
        checkRemoved()
        val iterator = componentMap.iterator()
        while(iterator.hasNext()){
            val (title, iteratorComponent) = iterator.next()
            if(iteratorComponent == component){
                iteratorComponent.onRemove()
                iterator.remove()
                return true
            }
        }
        return false
    }


    override fun update() {
        checkRemoved()
        for(component in componentMap.values){
            component.update()
        }
    }

    override fun onRemove() {
        removed = true
        for(component in componentMap.values){
            component.onRemove()
        }
    }


    override fun <T : ActiveComponent>addComponent(title: String, component: ShuffleboardComponent<T>, metadataEditor: MetadataEditor): T {
        checkRemoved()
        val componentMetadata = metadataDashboard.getSubDashboard(title)
        val r = component.init(title, dashboard, componentMetadata)
        componentMap[title] = r
        return r
    }

}
