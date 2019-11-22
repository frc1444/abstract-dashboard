package com.first1444.dashboard.advanced

interface AdvancedDashboard : Runnable {
    fun delete(key: String)
    fun delete(data: Sendable)

    operator fun set(key: String, data: Sendable)
    operator fun get(key: String): Sendable
}
