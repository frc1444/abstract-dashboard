package com.first1444.dashboard.value

import com.first1444.dashboard.value.listener.EntryListener
import com.first1444.dashboard.value.listener.EntryListenerFlag
import com.first1444.dashboard.value.listener.EntryNotification

interface BasicEntry {

    fun delete()

    val exists: Boolean
        @get:JvmName("exists")
        get

    val name: String
    var isPersistent: Boolean

    val setter: ValueSetter
    val strictSetter: ValueSetter
    val forceSetter: ValueSetter
    val defaultSetter: ValueSetter
    val strictDefaultSetter: ValueSetter

    val getter: ValueGetter

    fun addListener(listenerFlags: Collection<EntryListenerFlag>, listener: EntryListener): Boolean
    fun addListener(listenerFlags: Collection<EntryListenerFlag>, listener: (EntryNotification) -> Unit): EntryListener {
        val r = EntryListener(listener)
        val result = addListener(listenerFlags, r)
        check(result) { "We created a new EntryListener but it wasn't added!" }
        return r
    }
    fun removeListener(listener: EntryListener): Boolean

}
