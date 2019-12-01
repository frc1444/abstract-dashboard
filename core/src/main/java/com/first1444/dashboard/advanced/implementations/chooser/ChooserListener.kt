package com.first1444.dashboard.advanced.implementations.chooser

interface ChooserListener {
    fun onKeyChange(key: String)
    companion object {
        @JvmField
        val IGNORE = ChooserListener {}

        @JvmSynthetic
        inline operator fun invoke(crossinline lambda: (String) -> Unit) = object : ChooserListener {
            override fun onKeyChange(key: String) = lambda(key)
        }
    }
}
