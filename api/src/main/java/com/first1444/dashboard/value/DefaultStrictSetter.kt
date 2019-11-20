package com.first1444.dashboard.value

import com.first1444.dashboard.DifferentTypeDashboardException
import java.nio.ByteBuffer

class DefaultStrictSetter(
        private val setter: ValueSetter
) : ValueSetter {

    private inline fun set(setter: () -> Boolean): Boolean{
        val result = setter()
        if(!result){
            throw DifferentTypeDashboardException("Unable to set a value because the current value is a different type.")
        }
        return true
    }

    override fun setBoolean(value: Boolean): Boolean = set { setter.setBoolean(value) }

    override fun setDouble(value: Double): Boolean = set { setter.setDouble(value) }

    override fun setNumber(value: Number): Boolean = set { setter.setNumber(value) }

    override fun setString(value: String): Boolean = set { setter.setString(value) }

    override fun setRaw(value: ByteArray): Boolean = set { setter.setRaw(value) }

    override fun setRaw(value: ByteBuffer, len: Int): Boolean = set { setter.setRaw(value, len) }

    override fun setBooleanArray(value: BooleanArray): Boolean = set { setter.setBooleanArray(value) }

    override fun setBooleanArray(value: Array<Boolean>): Boolean = set { setter.setBooleanArray(value) }

    override fun setDoubleArray(value: DoubleArray): Boolean = set { setter.setDoubleArray(value) }

    override fun setNumberArray(value: Array<Number>): Boolean = set { setter.setNumberArray(value) }

    override fun setStringArray(value: Array<String>): Boolean = set { setter.setStringArray(value) }

}
