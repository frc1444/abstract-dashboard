package com.first1444.dashboard.advanced

import com.first1444.dashboard.BasicDashboard

class BasicAdvancedDashboard(
        override val title: String,
        private val basicDashboard: BasicDashboard
) : ActiveAdvancedDashboard {

    override fun update() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRemove() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(key: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(key: String, data: Sendable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(key: String): Sendable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
