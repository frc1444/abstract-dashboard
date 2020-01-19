package com.first1444.dashboard.advanced

/**
 * Allows a single [Sendable] instance to be added to this dashboard only once.
 *
 * Note that implementations may decide to do something unique when handling a [Sendable]
 */
interface SendableDashboard {
    fun delete(key: String): Boolean
    fun delete(sendable: Sendable<*>): Boolean

    /**
     * @return true if it was added, false otherwise
     */
    fun add(key: String, data: Sendable<*>): Boolean

}
