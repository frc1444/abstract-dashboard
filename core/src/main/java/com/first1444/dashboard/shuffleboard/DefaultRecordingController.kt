package com.first1444.dashboard.shuffleboard

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.value.BasicEntry


class DefaultRecordingController
/**
 * @param dashboard The root dashboard
 */
(dashboard: BasicDashboard) : RecordingController {

    companion object {
        private const val RECORDING_TABLE_NAME = "/Shuffleboard/.recording/"
        private const val RECORDING_CONTROL_KEY = RECORDING_TABLE_NAME + "RecordData"
        private const val RECORDING_FILE_NAME_FORMAT_KEY = RECORDING_TABLE_NAME + "FileNameFormat"
        private const val EVENT_MARKER_TABLE_NAME = RECORDING_TABLE_NAME + "events"
    }

    private val recordingControlEntry: BasicEntry = dashboard[RECORDING_CONTROL_KEY]
    private val recordingFileNameFormatEntry: BasicEntry = dashboard[RECORDING_FILE_NAME_FORMAT_KEY]
    private val eventsTable: BasicDashboard = dashboard.getSubDashboard(EVENT_MARKER_TABLE_NAME)

    override fun startRecording() {
        recordingControlEntry.strictSetter.setBoolean(true)
    }

    override fun stopRecording() {
        recordingControlEntry.strictSetter.setBoolean(false)
    }

    override fun setRecordingFileNameFormat(format: String) {
        recordingFileNameFormatEntry.strictSetter.setString(format)
    }

    override fun clearRecordingFileNameFormat() {
        recordingFileNameFormatEntry.delete()
    }

    override fun addEventMarker(name: String, description: String, importance: EventImportance) {
        eventsTable.getSubDashboard(name)["Info"]
                .strictSetter
                .setStringArray(arrayOf(description, importance.simpleName))
    }

}