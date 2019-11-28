package com.first1444.dashboard.livewindow

import com.first1444.dashboard.advanced.Sendable
import com.first1444.dashboard.enable.MutableEnabledProvider

interface LiveWindow : MutableEnabledProvider {
    /*
    The design of the WPI LiveWindow API: The live window can be enabled and disabled. In IterativeRobotBase, LiveWindow is
    enabled only when going into test mode and disabled at every other possible time. Although it can be disabled,
    telemetry can override this for certain Sendable objects.
     */

    fun delete(key: String): Boolean
    fun delete(sendable: Sendable<*>): Boolean

    /**
     * @return true if it was added, false otherwise
     */
    fun add(key: String, data: Sendable<*>): Boolean

    /**
     * When set to true, [sendable] will still update even if [isEnabled] is false.
     * @param sendable The [Sendable] to enable or disable
     * @param enabled true to enable telemetry, false to disable telemetry
     */
    fun setTelemetryEnabled(sendable: Sendable<*>, enabled: Boolean)
}
