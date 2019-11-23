package com.first1444.dashboard.advanced

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.BasicDashboard

class BasicAdvancedDashboard(
        override val title: String,
        private val basicDashboard: BasicDashboard
) : ActiveAdvancedDashboard {
    override fun <T : ActiveComponent> add(key: String, data: Sendable<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRemove() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(key: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}
