package com.first1444.dashboard.value

interface BasicEntry {

    fun delete()

    val name: String
    var persistent: Boolean

    val setter: ValueSetter
    val strictSetter: ValueSetter
    val forceSetter: ValueSetter
    val defaultSetter: ValueSetter
    val strictDefaultSetter: ValueSetter

    fun getValue(): BasicValue

    fun getBoolean(defaultValue: Boolean): Boolean

    fun getDouble(defaultValue: Double): Double

    fun getNumber(defaultValue: Number): Number

    fun getString(defaultValue: String): String

    fun getRaw(defaultValue: ByteArray): ByteArray

    fun getBooleanArray(defaultValue: BooleanArray): BooleanArray
    fun getBooleanArray(defaultValue: Array<Boolean>): Array<Boolean>

    fun getDoubleArray(defaultValue: DoubleArray): DoubleArray
    fun getDoubleArray(defaultValue: Array<Double>): Array<Double>

    fun getNumberArray(defaultValue: Array<Number>): Array<Number>

    fun getStringArray(defaultValue: Array<String>): Array<String>

}
