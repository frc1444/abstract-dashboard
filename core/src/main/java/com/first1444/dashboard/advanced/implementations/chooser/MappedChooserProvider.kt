package com.first1444.dashboard.advanced.implementations.chooser

interface MappedChooserProvider<out T> : ChooserProvider {
    val selected: T
}
