package com.first1444.dashboard.shuffleboard

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard

interface ShuffleboardContainer {
//    val rootShuffleboard: Shuffleboard
//
//    val basicDashboard: BasicDashboard
//    val advancedDashboard: AdvancedDashboard

//    fun createLayout(title: String, type: String): ShuffleboardContainer
//    fun createLayout(title: String, layoutType: LayoutType): ShuffleboardContainer = createLayout(title, layoutType.layoutName)
//
//    fun getLayoutOrCreate(title: String, type: String): ShuffleboardContainer
//    fun getLayoutOrCreate(title: String, layoutType: LayoutType): ShuffleboardContainer = getLayoutOrCreate(title, layoutType.layoutName)
//
//    /**
//     * @throws NoSuchElementException If the layout cannot be found
//     */
//    fun getLayout(title: String): ShuffleboardContainer
//
//    fun getLayoutOrNull(title: String): ShuffleboardContainer?

    val components: Collection<ActiveComponent>

    fun <T : ActiveComponent>addComponent(title: String, component: ShuffleboardComponent<T>, metadataEditor: MetadataEditor): T
    @JvmSynthetic
    fun <T : ActiveComponent>addComponent(title: String, component: ShuffleboardComponent<T>, metadataEditor: (metadataDashboard: BasicDashboard) -> Unit) = addComponent(title, component, MetadataEditor(metadataEditor))
    fun <T : ActiveComponent>addComponent(title: String, component: ShuffleboardComponent<T>) = addComponent(title, component, MetadataEditor.NOTHING)

    fun remove(title: String): Boolean
    fun remove(component: ActiveComponent): Boolean

}
