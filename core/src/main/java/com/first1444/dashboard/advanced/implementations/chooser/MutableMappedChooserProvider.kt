package com.first1444.dashboard.advanced.implementations.chooser

interface MutableMappedChooserProvider<T> : MappedChooserProvider<T> {
    fun addOption(key: String, value: T, makeDefault: Boolean)
    fun addOption(key: String, value: T) = addOption(key, value, false)

    fun remove(key: String): Boolean
    fun set(map: Map<String, T>, defaultKey: String)
}
