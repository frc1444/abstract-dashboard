package com.first1444.dashboard.value


class BasicValue(
        private val type: BasicValueType,
        private val value: Any
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BasicValue

        if (type != other.type) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }
    @Suppress("UNCHECKED_CAST")
    fun applyTo(setter: ValueSetter): Boolean{
        return when(type){
            BasicValueType.BOOLEAN -> setter.setBoolean(value as Boolean)
            BasicValueType.DOUBLE -> setter.setNumber(value as Number)
            BasicValueType.STRING -> setter.setString(value as String)
            BasicValueType.RAW -> setter.setRaw(value as ByteArray)
            BasicValueType.BOOLEAN_ARRAY -> {
                if(value is BooleanArray) {
                    setter.setBooleanArray(value)
                } else {
                    setter.setBooleanArray(value as Array<Boolean>)
                }
            }
            BasicValueType.DOUBLE_ARRAY -> {
                if(value is DoubleArray) {
                    setter.setDoubleArray(value)
                } else {
                    setter.setNumberArray(value as Array<Number>)
                }
            }
            BasicValueType.STRING_ARRAY -> setter.setStringArray(value as Array<String>)
        }
    }

    companion object {
        @JvmField
        val TRUE = makeBoolean(true)
        @JvmField
        val FALSE = makeBoolean(false)

        @JvmStatic
        fun makeBoolean(value: Boolean) = BasicValue(BasicValueType.BOOLEAN, value)
        @JvmStatic
        fun makeDouble(value: Double) = BasicValue(BasicValueType.DOUBLE, value)
        @JvmStatic
        fun makeString(value: String) = BasicValue(BasicValueType.STRING, value)
        @JvmStatic
        fun makeRaw(value: ByteArray) = BasicValue(BasicValueType.RAW, value)
        @JvmStatic
        fun makeBooleanArray(value: BooleanArray) = BasicValue(BasicValueType.BOOLEAN_ARRAY, value)
        @JvmStatic
        fun makeDoubleArray(value: DoubleArray) = BasicValue(BasicValueType.DOUBLE_ARRAY, value)
        @JvmStatic
        fun makeStringArray(value: Array<String>) = BasicValue(BasicValueType.STRING, value)
    }

}
