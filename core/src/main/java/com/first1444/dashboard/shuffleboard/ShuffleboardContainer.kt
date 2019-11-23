package com.first1444.dashboard.shuffleboard

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.AdvancedDashboard

interface ShuffleboardContainer {
    val rawDashboard: BasicDashboard
    val advancedDashboard: AdvancedDashboard

    val components: Collection<ActiveComponent>

    fun <T : ActiveComponent>add(title: String, component: ShuffleboardComponent<T>, metadataEditor: MetadataEditor): T
    @JvmSynthetic
    fun <T : ActiveComponent>add(title: String, component: ShuffleboardComponent<T>, metadataEditor: (metadataDashboard: BasicDashboard) -> Unit) = add(title, component, MetadataEditor(metadataEditor))
    fun <T : ActiveComponent>add(title: String, component: ShuffleboardComponent<T>) = add(title, component, MetadataEditor.NOTHING)

    fun <T : ActiveComponent>addOrGet(title: String, component: ShuffleboardComponent<T>, metadataEditor: MetadataEditor): T
    @JvmSynthetic
    fun <T : ActiveComponent>addOrGet(title: String, component: ShuffleboardComponent<T>, metadataEditor: (metadataDashboard: BasicDashboard) -> Unit) = add(title, component, MetadataEditor(metadataEditor))
    fun <T : ActiveComponent>addOrGet(title: String, component: ShuffleboardComponent<T>) = add(title, component, MetadataEditor.NOTHING)

    fun <T : ActiveComponent>get(title: String): T
    fun <T : ActiveComponent>get(title: String, component: ShuffleboardComponent<T>): T = get(title)

    fun <T : ActiveComponent>getOrNull(title: String): T?
    fun <T : ActiveComponent>getOrNull(title: String, component: ShuffleboardComponent<T>): T? = getOrNull(title)


    fun remove(title: String): Boolean
    fun remove(component: ActiveComponent): Boolean

}
