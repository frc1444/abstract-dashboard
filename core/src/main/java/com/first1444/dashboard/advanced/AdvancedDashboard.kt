package com.first1444.dashboard.advanced

interface AdvancedDashboard {
    fun delete(key: String)

    fun add(key: String, data: Sendable)
    operator fun get(key: String): Sendable
}
