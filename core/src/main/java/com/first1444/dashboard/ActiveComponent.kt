package com.first1444.dashboard

interface ActiveComponent {
    val title: String
    fun update()

    fun onRemove()

    companion object {
        @JvmStatic
        fun createTitleOnly(title: String) = object : ActiveComponent {
            override val title: String = title
            override fun update() {
            }
            override fun onRemove() {
            }
        }
    }
}
