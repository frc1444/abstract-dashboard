package com.first1444.dashboard.wpi

import com.first1444.dashboard.value.BasicValue
import com.first1444.dashboard.value.BasicValueType
import edu.wpi.first.networktables.NetworkTableType
import edu.wpi.first.networktables.NetworkTableValue

val NetworkTableValue.asBasicValue: BasicValue?
    get() {
        val type = type ?: error("The type cannot be null!")
        if(type == NetworkTableType.kUnassigned){
            return null
        }
        return BasicValue(when (type) {
            NetworkTableType.kUnassigned -> throw AssertionError("We just checked this above!")
            NetworkTableType.kBoolean -> BasicValueType.BOOLEAN
            NetworkTableType.kDouble -> BasicValueType.DOUBLE
            NetworkTableType.kString -> BasicValueType.STRING
            NetworkTableType.kRaw -> BasicValueType.RAW
            NetworkTableType.kBooleanArray -> BasicValueType.BOOLEAN_ARRAY
            NetworkTableType.kDoubleArray -> BasicValueType.DOUBLE_ARRAY
            NetworkTableType.kStringArray -> BasicValueType.STRING_ARRAY
            NetworkTableType.kRpc -> throw NotImplementedError("RPC is not supported yet!")
        }, value)
    }
