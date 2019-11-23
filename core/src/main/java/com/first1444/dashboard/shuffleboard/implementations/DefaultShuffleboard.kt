package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.shuffleboard.ActiveShuffleboard
import com.first1444.dashboard.shuffleboard.RecordingController
import com.first1444.dashboard.shuffleboard.ShuffleboardContainer

class DefaultShuffleboard(
        rootDashboard: BasicDashboard
) : ActiveShuffleboard {

    override val title: String = "Shuffleboard"


    private val dashboard = rootDashboard.getSubDashboard("/Shuffleboard")
    private val metadata = dashboard.getSubDashboard(".metadata")
    private val tabSelectEntry = metadata["Selected"]
    private val tabsEntry = metadata["Tabs"]

    override val recordingController: RecordingController = DefaultRecordingController(rootDashboard)

    private val container = DefaultShuffleboardContainer(title, dashboard, metadata)

    override val rawContainer: ShuffleboardContainer
        get() = container

    override fun selectTab(index: Int) {
        tabSelectEntry.forceSetter.setDouble(index.toDouble())
    }

    override fun selectTab(title: String) {
        tabSelectEntry.forceSetter.setString(title)
    }

    override fun get(title: String): ShuffleboardContainer {
        val r = container.getOrNull(title, ShuffleboardTabComponent)
        if(r != null){
            return r
        }
        val newTab = container.add(title, ShuffleboardTabComponent)
        updateTabsEntry()
        return newTab
    }

    override fun update() {
        container.update()
    }

    override fun onRemove() {
        container.onRemove()
    }

    private fun updateTabsEntry(){
        tabsEntry.strictSetter.setStringArray(container.components.map { it.title }.toTypedArray())
    }

}
