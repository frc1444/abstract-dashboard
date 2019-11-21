package com.first1444.dashboard.wpi

import com.first1444.dashboard.value.BasicValue
import com.first1444.dashboard.value.BasicValueType
import com.first1444.dashboard.value.ValueGetter
import edu.wpi.first.networktables.NetworkTableEntry
import edu.wpi.first.networktables.NetworkTableType

class EntryGetter(
        private val entry: NetworkTableEntry
) : ValueGetter {
    override val value: BasicValue
        get() {
            val value = entry.value
            return BasicValue(when (value.type ?: error("The type cannot be null!")) {
                NetworkTableType.kUnassigned -> error("Unassigned type for value: ${value.value}")
                NetworkTableType.kBoolean -> BasicValueType.BOOLEAN
                NetworkTableType.kDouble -> BasicValueType.DOUBLE
                NetworkTableType.kString -> BasicValueType.STRING
                NetworkTableType.kRaw -> BasicValueType.RAW
                NetworkTableType.kBooleanArray -> BasicValueType.BOOLEAN_ARRAY
                NetworkTableType.kDoubleArray -> BasicValueType.DOUBLE_ARRAY
                NetworkTableType.kStringArray -> BasicValueType.STRING_ARRAY
                NetworkTableType.kRpc -> throw NotImplementedError("RPC is not supported yet!")
            }, value.value)
        }

    override fun getBoolean(defaultValue: Boolean): Boolean = entry.getBoolean(defaultValue)

    override fun getDouble(defaultValue: Double): Double = entry.getDouble(defaultValue)

    override fun getNumber(defaultValue: Number): Number = entry.getNumber(defaultValue)

    override fun getString(defaultValue: String): String = entry.getString(defaultValue)

    override fun getRaw(defaultValue: ByteArray): ByteArray = entry.getRaw(defaultValue)

    override fun getBooleanArray(defaultValue: BooleanArray): BooleanArray = entry.getBooleanArray(defaultValue)

    override fun getBooleanArray(defaultValue: Array<Boolean>): Array<Boolean> = entry.getBooleanArray(defaultValue)

    override fun getDoubleArray(defaultValue: DoubleArray): DoubleArray = entry.getDoubleArray(defaultValue)

    override fun getDoubleArray(defaultValue: Array<Double>): Array<Double> = entry.getDoubleArray(defaultValue)

    override fun getNumberArray(defaultValue: Array<Number>): Array<Number> = entry.getNumberArray(defaultValue)

    override fun getStringArray(defaultValue: Array<String>): Array<String> = entry.getStringArray(defaultValue)

}
