package com.first1444.dashboard.value.listener

import com.first1444.dashboard.value.BasicValue

class EntryNotification(
        val name: String,
        val value: BasicValue?,
        val flags: Set<EntryListenerFlag>
)
