package com.first1444.dashboard.value

import java.nio.ByteBuffer

interface ValueSetter {

    fun set(value: BasicValue): Boolean = value.applyTo(this)

    fun setBoolean(value: Boolean): Boolean

    fun setDouble(value: Double): Boolean

    fun setNumber(value: Number): Boolean

    fun setString(value: String): Boolean

    fun setRaw(value: ByteArray): Boolean

    fun setRaw(value: ByteBuffer, len: Int): Boolean

    fun setBooleanArray(value: BooleanArray): Boolean

    fun setBooleanArray(value: Array<Boolean>): Boolean

    fun setDoubleArray(value: DoubleArray): Boolean

    fun setNumberArray(value: Array<Number>): Boolean

    fun setStringArray(value: Array<String>): Boolean
}
