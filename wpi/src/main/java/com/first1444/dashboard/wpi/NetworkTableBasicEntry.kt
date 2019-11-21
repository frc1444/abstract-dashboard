package com.first1444.dashboard.wpi

import com.first1444.dashboard.value.*
import edu.wpi.first.networktables.NetworkTableEntry

class NetworkTableBasicEntry(
        private val entry: NetworkTableEntry
) : BasicEntry {

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

}
