package com.first1444.dashboard.value

interface ValueProperty {
    fun getValue(): BasicValue
    val supportsGetting: Boolean

    fun setValue(value: BasicValue)
    val supportsSetting: Boolean
}
