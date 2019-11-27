package com.first1444.dashboard.enable

interface MutableEnabledProvider : EnabledProvider {
    override var isEnabled: Boolean
}
