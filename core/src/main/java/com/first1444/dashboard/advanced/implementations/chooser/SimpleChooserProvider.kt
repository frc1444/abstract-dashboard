package com.first1444.dashboard.advanced.implementations.chooser

class SimpleChooserProvider(
        private val listener: ChooserListener
) : MutableChooserProvider {
    private val stateLock = Object()
    private val _keys = LinkedHashSet<String>()
    private var _defaultKey: String = ""
    private var _selectedKey: String? = null

    override val keys: Collection<String>
        get() {
            synchronized(stateLock) {
                return _keys.toList()
            }
        }
    override var selectedKey: String
        get() {
            synchronized(stateLock){
                return _selectedKey ?: _defaultKey
            }
        }
        set(value) {
            synchronized(stateLock) {
                val oldValue = _selectedKey
                _selectedKey = value
                if(oldValue != value){
                    listener.onKeyChange(value)
                }
            }
        }
    override var defaultKey: String
        get() {
            synchronized(stateLock) {
                return _defaultKey
            }
        }
        set(value) {
            synchronized(stateLock){
                _defaultKey = value
            }
        }
    override fun clearSelected() {
        synchronized(stateLock){
            _selectedKey = null
        }
    }

    override fun add(key: String, makeDefault: Boolean): Boolean {
        synchronized(stateLock) {
            if (makeDefault) {
                val oldSelected = selectedKey
                _defaultKey = key
                val newSelected = selectedKey
                if(oldSelected != newSelected){
                    check(newSelected == key) { "Somehow the selectedKey changed but it's not equal to the new default value!" }
                    listener.onKeyChange(newSelected)
                }
            }
            return _keys.add(key)
        }
    }
    override fun remove(key: String): Boolean {
        synchronized(stateLock) {
            require(key != _defaultKey) { "Cannot remove the default key!" }
            if(key == _selectedKey){
                _selectedKey = null
            }
            return _keys.remove(key)
        }
    }


    override fun setKeys(newKeys: Collection<String>, defaultValue: String) {
        synchronized(stateLock) {
            _selectedKey = null
            _defaultKey = defaultValue
            _keys.clear()
            _keys.addAll(newKeys)
        }
    }
    override fun reset(){
        synchronized(stateLock) {
            _selectedKey = null
            _defaultKey = ""
            _keys.clear()
        }
    }
    // endregion

}
