package com.first1444.dashboard.value

interface BasicEntry {

    fun delete()

    val exists: Boolean
        @get:JvmName("exists")
        get

    val name: String
    var isPersistent: Boolean

    val setter: ValueSetter
    val strictSetter: ValueSetter
    val forceSetter: ValueSetter
    val defaultSetter: ValueSetter
    val strictDefaultSetter: ValueSetter

    val getter: ValueGetter

}
