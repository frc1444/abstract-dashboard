package com.first1444.dashboard.advanced.implementations.chooser

interface ChooserProvider {
    val keys: Collection<String>

    var selectedKey: String
    val defaultKey: String

    fun clearSelected()
}
