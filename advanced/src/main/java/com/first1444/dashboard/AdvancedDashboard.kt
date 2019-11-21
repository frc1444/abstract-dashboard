package com.first1444.dashboard

interface AdvancedDashboard : Runnable {
    fun delete(key: String)
    fun delete(data: Sendable)

    fun putData(key: String, data: Sendable)
    fun getData(key: String): Sendable
}
