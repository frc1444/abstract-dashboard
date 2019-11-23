package com.first1444.dashboard.shuffleboard

interface Shuffleboard {
    val recordingController: RecordingController

    fun selectTab(index: Int)
    fun selectTab(title: String)

    /**
     * Gets the desired tab
     */
    operator fun get(title: String): ShuffleboardContainer

    /**
     * This is not recommended to be used. It allows you to change the raw values of the root shuffleboard dashboard/table
     */
    val rawContainer: ShuffleboardContainer

}