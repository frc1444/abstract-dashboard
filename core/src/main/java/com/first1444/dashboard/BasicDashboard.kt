package com.first1444.dashboard

import com.first1444.dashboard.value.BasicEntry

interface BasicDashboard {

    fun delete(key: String)

    operator fun get(key: String): BasicEntry

    fun getSubDashboard(key: String): BasicDashboard
}
