package com.first1444.dashboard.wpi

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.Sendable

class VideoSourceSendable(
        private val uri: String
) : Sendable<ActiveComponent> {
    companion object {
        const val CAMERA_SERVER_PROTOCOL = "camera_server://"
    }
    override fun init(title: String, dashboard: BasicDashboard): ActiveComponent {
        dashboard[".ShuffleboardURI"].strictSetter.setString(uri)
        return ActiveComponent.createTitleOnly(title)
    }

}
