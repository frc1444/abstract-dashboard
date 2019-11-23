package com.first1444.dashboard.value.listener

enum class EntryListenerFlag(
        val value: Int
) {
    IMMEDIATE(0x01),
    LOCAL(0x02),
    NEW(0x04),
    DELETE(0x08),
    UPDATE(0x10),
    FLAGS(0x20)
}
