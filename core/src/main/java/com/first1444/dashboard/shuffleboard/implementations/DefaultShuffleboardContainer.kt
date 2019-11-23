package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.AdvancedDashboard
import com.first1444.dashboard.advanced.Sendable
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

    override val rawDashboard: BasicDashboard
        get() = dashboard

    override val advancedDashboard: AdvancedDashboard = object : AdvancedDashboard {
        override fun delete(key: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun <T : ActiveComponent> add(key: String, data: Sendable<T>): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }


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
            val (_, iteratorComponent) = iterator.next()
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


    override fun <T : ActiveComponent>add(title: String, component: ShuffleboardComponent<T>, metadataEditor: MetadataEditor): T {
        checkRemoved()
        check(title !in componentMap) { "$title is already present!" }

        val componentMetadata = metadataDashboard.getSubDashboard(title)
        val r = component.init(title, dashboard, componentMetadata)
        componentMap[title] = r
        return r
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ActiveComponent> addOrGet(title: String, component: ShuffleboardComponent<T>, metadataEditor: MetadataEditor): T {
        checkRemoved()
        if(title in componentMap) {
            return componentMap[title] as T
        }
        return add(title, component, metadataEditor)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ActiveComponent> get(title: String): T {
        return componentMap[title] as T
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ActiveComponent> getOrNull(title: String): T? {
        return componentMap[title] as T?
    }

}
