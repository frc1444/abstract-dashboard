package com.first1444.dashboard.advanced.implementations

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.ActiveComponentMultiplexer
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.Sendable
import com.first1444.dashboard.advanced.SendableHelper
import com.first1444.dashboard.value.BasicValue
import com.first1444.dashboard.value.ValueProperty
import com.first1444.dashboard.value.implementations.PropertyActiveComponent
import java.util.concurrent.atomic.AtomicInteger


class SendableChooser
/**
 * Creates a [SendableChooser]
 * @param instanceNumber The instance number. If you override this, you should make this a large value so it doesn't conflict
 */
@JvmOverloads
constructor(
        private val instanceNumber: Int = instanceCounter.getAndIncrement()
) : Sendable<ActiveComponent> {
    companion object {
        private const val DEFAULT = "default"
        private const val SELECTED = "selected"
        private const val ACTIVE = "active"
        private const val OPTIONS = "options"
        private const val INSTANCE = ".instance"

        private val instanceCounter = AtomicInteger()
    }
    interface ChooserListener {
        fun onKeyChange(key: String)
        companion object {
            @JvmSynthetic
            operator fun invoke(lambda: (String) -> Unit) = object : ChooserListener {
                override fun onKeyChange(key: String) {
                    lambda(key)
                }
            }
        }
    }

    private val listeners = LinkedHashSet<ChooserListener>()

    private val stateLock = Object()
    private val keys = LinkedHashSet<String>()
    private var _defaultKey: String = ""
    private var _selectedKey: String? = null

    // region getters and setters to change state
    var selectedKey: String
        get() {
            synchronized(stateLock) {
                return _selectedKey ?: _defaultKey
            }
        }
        set(value) {
            synchronized(stateLock) {
                _selectedKey = value
            }
        }
    var defaultKey: String
        get() {
            synchronized(stateLock){
                return _defaultKey
            }
        }
        set(value){
            synchronized(stateLock){
                _defaultKey = value
            }
        }

    @JvmOverloads
    fun add(key: String, makeDefault: Boolean = false): Boolean {
        synchronized(stateLock) {
            if (makeDefault) {
                _defaultKey = key
            }
            return keys.add(key)
        }
    }
    fun remove(key: String): Boolean {
        synchronized(stateLock) {
            require(key != _defaultKey) { "Cannot remove the default key!" }
            return keys.remove(key)
        }
    }


    fun setKeys(newKeys: Collection<String>, defaultValue: String) {
        synchronized(stateLock) {
            _selectedKey = null
            _defaultKey = defaultValue
            keys.clear()
            keys.addAll(newKeys)
        }
    }
    fun reset(){
        synchronized(stateLock) {
            _selectedKey = null
            _defaultKey = ""
            keys.clear()
        }
    }
    // endregion

    // region listener adders/removers/setters
    fun addListener(listener: ChooserListener): Boolean {
        synchronized(listeners){
            return listeners.add(listener)
        }
    }
    fun removeListener(listener: ChooserListener): Boolean {
        synchronized(listeners){
            return listeners.remove(listener)
        }
    }
    fun clearListeners(){
        synchronized(listeners){
            listeners.clear()
        }
    }
    fun setListeners(newListeners: Collection<ChooserListener>){
        synchronized(listeners){
            listeners.clear()
            listeners.addAll(newListeners)
        }
    }
    // endregion

    override fun init(title: String, dashboard: BasicDashboard): ActiveComponent {
        SendableHelper(dashboard)
                .setDashboardType("String Chooser")
        dashboard[INSTANCE].strictSetter.setDouble(instanceNumber.toDouble())

        return ActiveComponentMultiplexer(title, listOf(
                PropertyActiveComponent("", dashboard[DEFAULT], ValueProperty.createGetOnly { BasicValue.makeString(defaultKey) }),
                PropertyActiveComponent("", dashboard[OPTIONS], ValueProperty.createGetOnly { BasicValue.makeStringArray(keys.toTypedArray()) }),
                PropertyActiveComponent("", dashboard[ACTIVE], ValueProperty.createGetOnly { BasicValue.makeString(selectedKey) }),
                PropertyActiveComponent("", dashboard[SELECTED], ValueProperty.create({ BasicValue.makeString(selectedKey) }, { selectedKey = it.value as String }))
        ))
    }

}
