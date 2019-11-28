package com.first1444.dashboard.enable

interface EnabledProvider {
    val isEnabled: Boolean

    companion object {
        @JvmSynthetic
        operator fun invoke(lambda: () -> Boolean) = object : EnabledProvider {
            override val isEnabled: Boolean
                get() = lambda()
        }
    }
}
