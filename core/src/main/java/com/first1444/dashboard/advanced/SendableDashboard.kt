package com.first1444.dashboard.advanced

interface SendableDashboard {

    fun delete(key: String): Boolean
    fun delete(sendable: Sendable<*>): Boolean

    fun add(key: String, data: Sendable<*>)
}
