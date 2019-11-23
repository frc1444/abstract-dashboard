package com.first1444.dashboard.wpi

import com.first1444.dashboard.value.*
import com.first1444.dashboard.value.listener.EntryListener
import com.first1444.dashboard.value.listener.EntryListenerFlag
import com.first1444.dashboard.value.listener.EntryNotification
import edu.wpi.first.networktables.NetworkTableEntry
import java.util.*
import kotlin.collections.HashMap

class NetworkTableBasicEntry(
        private val entry: NetworkTableEntry
) : BasicEntry {

    private val listeners = HashMap<EntryListener, Int>()

    override fun delete() {
        entry.delete()
    }

    override val exists: Boolean
        get() = entry.exists()

    override val name: String
        get() = entry.name
    override var isPersistent: Boolean
        get() = entry.isPersistent
        set(value) {
            if(value){
                entry.setPersistent()
            } else {
                entry.clearPersistent()
            }
        }
    override val setter: ValueSetter = EntrySetter(entry)
    override val strictSetter: ValueSetter = DefaultStrictSetter(setter)
    override val forceSetter: ValueSetter = EntryForceSetter(entry)
    override val defaultSetter: ValueSetter = EntryDefaultSetter(entry)
    override val strictDefaultSetter: ValueSetter = DefaultStrictSetter(defaultSetter)

    override val getter: ValueGetter = EntryGetter(entry)

    override fun addListener(listenerFlags: Collection<EntryListenerFlag>, listener: EntryListener): Boolean {
        if(listener in listeners){
            return false
        }
        var bitListenerFlags = 0
        for(flag in listenerFlags){
            bitListenerFlags = bitListenerFlags or flag.value
        }
        listeners[listener] = entry.addListener({
            val bitFlags = it.flags
            val flags = EnumSet.allOf(EntryListenerFlag::class.java)
            val iterator = flags.iterator()
            while(iterator.hasNext()){
                val flag = iterator.next()
                if(flag.value and bitFlags == 0){
                    iterator.remove()
                }
            }
            val notification = EntryNotification(it.name, it.value.asBasicValue, flags)
            listener.onNotification(notification)
        }, bitListenerFlags)
        return true
    }

    override fun removeListener(listener: EntryListener): Boolean {
        return listeners.remove(listener).let {
            if(it != null){
                entry.removeListener(it)
            }
            it != null
        }
    }

}
