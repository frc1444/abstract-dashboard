package com.first1444.dashboard.value

interface ValueProperty {
    fun getValue(): BasicValue
    val supportsGetting: Boolean

    fun setValue(value: BasicValue)
    val supportsSetting: Boolean

    @FunctionalInterface
    interface Getter {
        fun get(): BasicValue
    }
    @FunctionalInterface
    interface Setter {
        fun set(value: BasicValue)
    }
    companion object {
        @JvmSynthetic
        inline fun createGetOnly(crossinline getter: () -> BasicValue) = object : ValueProperty {
            override fun getValue(): BasicValue = getter()
            override val supportsGetting: Boolean = true

            override fun setValue(value: BasicValue) {
                throw UnsupportedOperationException()
            }
            override val supportsSetting: Boolean = false

        }
        @JvmStatic
        fun createGetOnly(getter: Getter) = createGetOnly(getter::get)
        @JvmSynthetic
        inline fun createSetOnly(crossinline setter: (BasicValue) -> Unit) = object : ValueProperty {
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
        fun createSetOnly(setter: Setter) = createSetOnly(setter::set)
        @JvmSynthetic
        inline fun create(crossinline getter: () -> BasicValue, crossinline setter: (BasicValue) -> Unit) = object : ValueProperty {
            override fun getValue(): BasicValue = getter()
            override val supportsGetting: Boolean = true
            override fun setValue(value: BasicValue) {
                setter(value)
            }
            override val supportsSetting: Boolean = true
        }
        @JvmStatic
        fun create(getter: Getter, setter: Setter) = create(getter::get, setter::set)
    }
}
