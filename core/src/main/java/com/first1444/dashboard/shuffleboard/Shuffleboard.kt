package com.first1444.dashboard.shuffleboard

interface Shuffleboard {
    val recordingController: RecordingController

    fun selectTab(index: Int)
    fun selectTab(title: String)

}