package com.first1444.dashboard.wpi

import com.first1444.dashboard.value.ValueSetter
import edu.wpi.first.networktables.NetworkTableEntry
import java.nio.ByteBuffer

class EntryForceSetter(
    private val entry: NetworkTableEntry
) : ValueSetter {
    private inline fun set(setter: () -> Unit): Boolean {
        setter()
        return true
    }
    override fun setBoolean(value: Boolean): Boolean = set { entry.forceSetBoolean(value) }

    override fun setDouble(value: Double): Boolean = set { entry.forceSetDouble(value) }

    override fun setNumber(value: Number): Boolean = set { entry.forceSetNumber(value) }

    override fun setString(value: String): Boolean = set { entry.forceSetString(value) }

    override fun setRaw(value: ByteArray): Boolean = set { entry.forceSetRaw(value) }

    override fun setRaw(value: ByteBuffer, len: Int): Boolean = set { entry.forceSetRaw(ByteArray(len).apply { value.get(this) }) }

    override fun setBooleanArray(value: BooleanArray): Boolean = set { entry.forceSetBooleanArray(value) }

    override fun setBooleanArray(value: Array<Boolean>): Boolean = set { entry.forceSetBooleanArray(value) }

    override fun setDoubleArray(value: DoubleArray): Boolean = set { entry.forceSetDoubleArray(value) }

    override fun setNumberArray(value: Array<Number>): Boolean = set { entry.forceSetNumberArray(value) }

    override fun setStringArray(value: Array<String>): Boolean = set { entry.forceSetStringArray(value) }

}
