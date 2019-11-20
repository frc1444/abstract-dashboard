package com.first1444.dashboard.wpi

import com.first1444.dashboard.value.ValueSetter
import edu.wpi.first.networktables.NetworkTableEntry
import java.nio.ByteBuffer

class EntrySetter(
        private val entry: NetworkTableEntry
) : ValueSetter {
    override fun setBoolean(value: Boolean): Boolean = entry.setBoolean(value)

    override fun setDouble(value: Double): Boolean = entry.setDouble(value)

    override fun setNumber(value: Number): Boolean = entry.setNumber(value)

    override fun setString(value: String): Boolean = entry.setString(value)

    override fun setRaw(value: ByteArray): Boolean = entry.setRaw(value)

    override fun setRaw(value: ByteBuffer, len: Int): Boolean = entry.setRaw(value, len)

    override fun setBooleanArray(value: BooleanArray): Boolean = entry.setBooleanArray(value)

    override fun setBooleanArray(value: Array<Boolean>): Boolean = entry.setBooleanArray(value)

    override fun setDoubleArray(value: DoubleArray): Boolean = entry.setDoubleArray(value)

    override fun setNumberArray(value: Array<Number>): Boolean = entry.setNumberArray(value)

    override fun setStringArray(value: Array<String>): Boolean = entry.setStringArray(value)

}
