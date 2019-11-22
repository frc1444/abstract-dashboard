package com.first1444.dashboard.shuffleboard

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.AdvancedDashboard
import com.first1444.dashboard.shuffleboard.types.LayoutType

interface ShuffleboardContainer {
    val rootShuffleboard: Shuffleboard

    val basicDashboard: BasicDashboard
    val advancedDashboard: AdvancedDashboard

    fun createLayout(title: String, type: String): ShuffleboardContainer
    fun createLayout(title: String, layoutType: LayoutType): ShuffleboardContainer = createLayout(title, layoutType.layoutName)

    fun getLayoutOrCreate(title: String, type: String): ShuffleboardContainer
    fun getLayoutOrCreate(title: String, layoutType: LayoutType): ShuffleboardContainer = getLayoutOrCreate(title, layoutType.layoutName)

    /**
     * @throws NoSuchElementException If the layout cannot be found
     */
    fun getLayout(title: String): ShuffleboardContainer

    fun getLayoutOrNull(title: String): ShuffleboardContainer?

//    val components: List<ActiveComponent>

    fun addComponent(title: String, component: ShuffleboardComponent, metadataEditor: MetadataEditor): ActiveComponent
    @JvmSynthetic
    fun addComponent(title: String, component: ShuffleboardComponent, metadataEditor: (metadataDashboard: BasicDashboard) -> Unit) = addComponent(title, component, MetadataEditor(metadataEditor))
    fun addComponent(title: String, component: ShuffleboardComponent) = addComponent(title, component, MetadataEditor.NOTHING)

}
