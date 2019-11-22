package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.shuffleboard.ActiveShuffleboard
import com.first1444.dashboard.shuffleboard.ActiveShuffleboardContainer
import com.first1444.dashboard.shuffleboard.RecordingController

class DefaultShuffleboard(
        rootDashboard: BasicDashboard
) : ActiveShuffleboard {
    override val title: String = "Shuffleboard"


    private val dashboard = rootDashboard.getSubDashboard("/Shuffleboard")
    private val metadata = dashboard.getSubDashboard(".metadata")
    private val tabSelectEntry = metadata["Selected"]

    override val recordingController: RecordingController = DefaultRecordingController(rootDashboard)

    private val container = DefaultShuffleboardContainer(title, dashboard, metadata)

    override fun selectTab(index: Int) {
        tabSelectEntry.forceSetter.setDouble(index.toDouble())
    }

    override fun selectTab(title: String) {
        tabSelectEntry.forceSetter.setString(title)
    }

    override fun update() {
        container.update()
    }

    override fun onRemove() {
        container.onRemove()
    }

}
