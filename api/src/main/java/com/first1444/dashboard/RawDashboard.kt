package com.first1444.dashboard

import com.first1444.dashboard.value.BasicEntry

interface RawDashboard {

    fun delete(key: String)

    operator fun get(key: String): BasicEntry

    operator fun contains(key: String): Boolean
}
