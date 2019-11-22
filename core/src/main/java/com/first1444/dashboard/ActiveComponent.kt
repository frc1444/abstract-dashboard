package com.first1444.dashboard

interface ActiveComponent {
    val title: String
    fun update()

    fun onRemove()
}
