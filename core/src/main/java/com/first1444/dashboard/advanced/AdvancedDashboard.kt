package com.first1444.dashboard.advanced

import com.first1444.dashboard.ActiveComponent

interface AdvancedDashboard {
    fun delete(key: String): Boolean

    fun <T : ActiveComponent>add(key: String, data: Sendable<T>): T
}
