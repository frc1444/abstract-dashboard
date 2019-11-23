package com.first1444.dashboard.value.implementations

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.value.BasicEntry
import com.first1444.dashboard.value.ValueProperty
import com.first1444.dashboard.value.listener.EntryListener
import com.first1444.dashboard.value.listener.EntryListenerFlag
import java.util.*

class PropertyActiveComponent(
        override val title: String,
        private val entry: BasicEntry,
        private val property: ValueProperty
) : ActiveComponent {
    private var active = false

    private val listener: EntryListener? = if(property.supportsSetting){
        EntryListener {
            property.setValue(it.value!!) // TODO think about handling nulls
        }
    } else null

    override fun update() {
        if(!active){
            if(listener != null) {
                entry.addListener(EnumSet.of(EntryListenerFlag.IMMEDIATE, EntryListenerFlag.NEW, EntryListenerFlag.UPDATE), listener)
            }
            active = true
        }
        if(property.supportsGetting){
            entry.setter.set(property.getValue())
        }
    }

    override fun onRemove() {
        active = false
        if(listener != null) {
            entry.removeListener(listener)
        }
    }

}
