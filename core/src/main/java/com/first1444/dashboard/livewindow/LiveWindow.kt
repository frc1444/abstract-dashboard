package com.first1444.dashboard.livewindow

import com.first1444.dashboard.advanced.Sendable
import com.first1444.dashboard.advanced.SendableDashboard
import com.first1444.dashboard.enable.MutableEnabledProvider

interface LiveWindow : SendableDashboard, MutableEnabledProvider {

    /**
     * When set to true, [sendable] will still update even if [isEnabled] is false.
     * @param sendable The [Sendable] to enable or disable
     * @param enabled true to enable telemetry, false to disable telemetry
     */
    fun setTelemetryEnabled(sendable: Sendable<*>, enabled: Boolean)
}
