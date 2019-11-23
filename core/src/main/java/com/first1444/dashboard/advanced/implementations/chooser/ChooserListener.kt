package com.first1444.dashboard.advanced.implementations.chooser

interface ChooserListener {
    fun onKeyChange(key: String)
    companion object {
        @JvmField
        val IGNORE = ChooserListener {}

        @JvmSynthetic
        operator fun invoke(lambda: (String) -> Unit) = object : ChooserListener {
            override fun onKeyChange(key: String) {
                lambda(key)
            }
        }
    }
}