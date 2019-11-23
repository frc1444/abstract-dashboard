package com.first1444.dashboard.advanced.implementations.chooser

interface MutableChooserProvider : ChooserProvider {

    override var defaultKey: String

    fun add(key: String, makeDefault: Boolean): Boolean
    fun add(key: String): Boolean = add(key, false)
    fun remove(key: String): Boolean

    fun setKeys(newKeys: Collection<String>, defaultValue: String)
    fun reset()
}
