package com.first1444.dashboard.advanced.implementations.chooser

class SimpleMappedChooserProvider<T>(
        listener: ChooserListener
) : MutableMappedChooserProvider<T> {
    private val stateLock: Any = Object()
    private val chooserProvider = SimpleChooserProvider(listener)
    private val map = HashMap<String, T>()

    override fun addOption(key: String, value: T, makeDefault: Boolean) {
        synchronized(stateLock){
            chooserProvider.add(key, makeDefault)
            require(key !in map){ "This should never happen! key=$key. If you add a key, chooserProvider should throw an exception if it's in our map!" }
            map[key] = value
        }
    }

    override fun remove(key: String): Boolean {
        synchronized(stateLock){
            val r = key in map
            map.remove(key)
            return r
        }
    }

    override fun set(map: Map<String, T>, defaultKey: String) {
        synchronized(stateLock){
            chooserProvider.setKeys(map.keys, defaultKey)
        }
    }

    override val selected: T
        get() {
            val key = chooserProvider.selectedKey
            @Suppress("UNCHECKED_CAST")
            return map[key] as T
        }
    override val keys: Collection<String>
        get() = chooserProvider.keys
    override var selectedKey: String
        get() = chooserProvider.selectedKey
        set(value) {
            chooserProvider.selectedKey = value
        }
    override val defaultKey: String
        get() = chooserProvider.defaultKey

    override fun clearSelected() {
        chooserProvider.clearSelected()
    }

}
