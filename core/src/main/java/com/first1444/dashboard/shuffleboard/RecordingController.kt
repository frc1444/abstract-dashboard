package com.first1444.dashboard.shuffleboard

interface RecordingController {

    fun startRecording()

    fun stopRecording()

    fun setRecordingFileNameFormat(format: String)
    fun clearRecordingFileNameFormat()

    fun addEventMarker(name: String, description: String, importance: EventImportance)
}
