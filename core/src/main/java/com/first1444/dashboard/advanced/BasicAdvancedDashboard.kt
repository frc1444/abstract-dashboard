package com.first1444.dashboard.advanced

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard

class BasicAdvancedDashboard(
        override val title: String,
        private val basicDashboard: BasicDashboard
) : ActiveAdvancedDashboard {

    private val componentMap = HashMap<String, ActiveComponent>()
    override fun <T : ActiveComponent> add(key: String, data: Sendable<T>): T {
        check(key !in componentMap) { "key=$key is already present!" }

        val r = data.init(key, basicDashboard.getSubDashboard(key))
        componentMap[key] = r
        return r
    }
    override fun delete(key: String): Boolean {
        return componentMap.remove(key) != null
    }

    override fun delete(activeComponent: ActiveComponent): Boolean {
        val iterator = componentMap.iterator()
        while(iterator.hasNext()){
            val (name, component) = iterator.next()
            if(component == activeComponent){
                basicDashboard.delete(name)
                activeComponent.onRemove()
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun update() {
        for(component in componentMap.values){
            component.update()
        }
    }

    override fun onRemove() {
        for(component in componentMap.values){
            component.onRemove()
        }
    }

}
