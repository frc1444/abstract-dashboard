package com.first1444.dashboard.smartdashboard

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.BasicAdvancedDashboard

class DefaultSmartDashboard(
        rootDashboard: BasicDashboard
) : ActiveSmartDashboard {
    override val title: String = "SmartDashboard"

    override val basicDashboard: BasicDashboard = rootDashboard.getSubDashboard("SmartDashboard")
    override val dashboard = BasicAdvancedDashboard("SmartDashboard", basicDashboard)

    override fun update() {
        dashboard.update()
    }

    override fun onRemove() {
        dashboard.onRemove()
    }

}
