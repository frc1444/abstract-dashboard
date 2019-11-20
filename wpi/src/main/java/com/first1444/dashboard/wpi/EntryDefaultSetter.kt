package com.first1444.dashboard.wpi

import com.first1444.dashboard.value.ValueSetter
import edu.wpi.first.networktables.NetworkTableEntry
import java.nio.ByteBuffer

class EntryDefaultSetter(
        private val entry: NetworkTableEntry
) : ValueSetter {
    override fun setBoolean(value: Boolean): Boolean = entry.setDefaultBoolean(value)

    override fun setDouble(value: Double): Boolean = entry.setDefaultDouble(value)

    override fun setNumber(value: Number): Boolean = entry.setDefaultNumber(value)

    override fun setString(value: String): Boolean = entry.setDefaultString(value)

    override fun setRaw(value: ByteArray): Boolean = entry.setDefaultRaw(value)

    override fun setRaw(value: ByteBuffer, len: Int): Boolean = entry.setDefaultRaw(ByteArray(len).apply { value.get(this) })

    override fun setBooleanArray(value: BooleanArray): Boolean = entry.setDefaultBooleanArray(value)

    override fun setBooleanArray(value: Array<Boolean>): Boolean = entry.setDefaultBooleanArray(value)

    override fun setDoubleArray(value: DoubleArray): Boolean = entry.setDefaultDoubleArray(value)

    override fun setNumberArray(value: Array<Number>): Boolean = entry.setDefaultNumberArray(value)

    override fun setStringArray(value: Array<String>): Boolean = entry.setDefaultStringArray(value)

}
