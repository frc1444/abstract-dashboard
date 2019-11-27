package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.BasicDashboard

class GyroMetadataHelper(
        private val metadataDashboard: BasicDashboard
) {
    private val propertiesDashboard: BasicDashboard get() = metadataDashboard.getSubDashboard("Properties")
    fun setMajorTickSpacing(majorTickSpacing: Double): GyroMetadataHelper {
        propertiesDashboard["Major tick spacing"].strictSetter.setDouble(majorTickSpacing)
        return this
    }
    fun setStartingAngle(startingAngleDegrees: Double): GyroMetadataHelper {
        propertiesDashboard["Starting angle"].strictSetter.setDouble(startingAngleDegrees)
        return this
    }

    /**
     * Only works on early 2020-beta Shuffleboard versions and all versions after 2020
     * @param isCounterClockwise true to set the gyro to be counter clockwise, false for clockwise
     */
    fun setCounterClockwise(isCounterClockwise: Boolean): GyroMetadataHelper {
        propertiesDashboard["Counter clockwise"].strictSetter.setBoolean(isCounterClockwise)
        return this
    }
}
