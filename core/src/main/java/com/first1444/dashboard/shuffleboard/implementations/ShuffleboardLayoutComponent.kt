package com.first1444.dashboard.shuffleboard.implementations

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.shuffleboard.ActiveShuffleboardContainer
import com.first1444.dashboard.shuffleboard.ComponentMetadataHelper
import com.first1444.dashboard.shuffleboard.ShuffleboardComponent
import com.first1444.dashboard.shuffleboard.types.LayoutType

/**
 * When initialized, creates an [ActiveComponent] that contains the current components that have been added
 */
class ShuffleboardLayoutComponent(
        private val layoutName: String
) : ShuffleboardComponent<ActiveShuffleboardContainer> {

    constructor(layoutType: LayoutType) : this(layoutType.layoutName)

    override fun init(title: String, parentDashboard: BasicDashboard, metadataDashboard: BasicDashboard): ActiveShuffleboardContainer {
        val dashboard = parentDashboard.getSubDashboard(title)
        ComponentMetadataHelper(metadataDashboard)
                .setType("ShuffleboardLayout")
                .setPreferredComponent(layoutName)

        return DefaultShuffleboardContainer(title, dashboard, metadataDashboard)
    }
}
