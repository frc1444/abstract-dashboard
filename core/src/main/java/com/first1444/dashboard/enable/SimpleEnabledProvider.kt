package com.first1444.dashboard.enable

class SimpleEnabledProvider
@JvmOverloads constructor(
        startEnabled: Boolean = false
) : MutableEnabledProvider {
    @Volatile // Just add some thread safety because why not.
    override var isEnabled: Boolean = startEnabled
}
