package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.shuffleboard.EventImportance
import com.first1444.dashboard.shuffleboard.RecordingController
import com.first1444.dashboard.value.BasicEntry


class DefaultRecordingController
/**
 * @param rootDashboard The root dashboard
 */
(rootDashboard: BasicDashboard) : RecordingController {

    companion object {
        private const val RECORDING_TABLE_NAME = "/Shuffleboard/.recording/"
        private const val RECORDING_CONTROL_KEY = RECORDING_TABLE_NAME + "RecordData"
        private const val RECORDING_FILE_NAME_FORMAT_KEY = RECORDING_TABLE_NAME + "FileNameFormat"
        private const val EVENT_MARKER_TABLE_NAME = RECORDING_TABLE_NAME + "events"
    }

    private val recordingControlEntry: BasicEntry = rootDashboard[RECORDING_CONTROL_KEY]
    private val recordingFileNameFormatEntry: BasicEntry = rootDashboard[RECORDING_FILE_NAME_FORMAT_KEY]
    private val eventsTable: BasicDashboard = rootDashboard.getSubDashboard(EVENT_MARKER_TABLE_NAME)

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