package com.first1444.dashboard.value

interface ValueProperty {
    fun getValue(): BasicValue
    val supportsGetting: Boolean

    fun setValue(value: BasicValue)
    val supportsSetting: Boolean

    companion object {
        @JvmStatic
        fun createGetOnly(getter: () -> BasicValue) = object : ValueProperty {
            override fun getValue(): BasicValue = getter()
            override val supportsGetting: Boolean = true

            override fun setValue(value: BasicValue) {
                throw UnsupportedOperationException()
            }
            override val supportsSetting: Boolean = false

        }
        @JvmStatic
        fun createSetOnly(setter: (BasicValue) -> Unit) = object : ValueProperty {
            override fun getValue(): BasicValue {
                throw UnsupportedOperationException()
            }
            override val supportsGetting: Boolean = false

            override fun setValue(value: BasicValue) {
                setter(value)
            }
            override val supportsSetting: Boolean = true
        }
        @JvmStatic
        fun create(getter: () -> BasicValue, setter: (BasicValue) -> Unit) = object : ValueProperty {
            override fun getValue(): BasicValue = getter()
            override val supportsGetting: Boolean = true
            override fun setValue(value: BasicValue) {
                setter(value)
            }
            override val supportsSetting: Boolean = true

        }
    }
}
