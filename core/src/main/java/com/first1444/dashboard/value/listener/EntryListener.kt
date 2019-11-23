package com.first1444.dashboard.value.listener

interface EntryListener {
    fun onNotification(notification: EntryNotification)

    companion object {
        @JvmSynthetic
        operator fun invoke(lambda: (EntryNotification) -> Unit) = object : EntryListener {
            override fun onNotification(notification: EntryNotification) = lambda(notification)
        }
    }
}
