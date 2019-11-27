package com.first1444.dashboard.livewindow

import com.first1444.dashboard.advanced.SendableDashboard
import com.first1444.dashboard.enable.MutableEnabledProvider

interface LiveWindow : MutableEnabledProvider {
    /*
    The design of the WPI LiveWindow API: The live window can be enabled and disabled. In IterativeRobotBase, LiveWindow is
    enabled only when going into test mode and disabled at every other possible time. Although it can be disabled,
    telemetry can override this for certain Sendable objects.
     */

    val sendableDashboard: SendableDashboard
}
