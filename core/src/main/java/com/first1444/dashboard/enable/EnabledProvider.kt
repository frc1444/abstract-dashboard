package com.first1444.dashboard.enable

interface EnabledProvider {
    val isEnabled: Boolean

    companion object {
        @JvmSynthetic
        inline operator fun invoke(crossinline lambda: () -> Boolean) = object : EnabledProvider {
            override val isEnabled: Boolean
                get() = lambda()
        }
    }
}
