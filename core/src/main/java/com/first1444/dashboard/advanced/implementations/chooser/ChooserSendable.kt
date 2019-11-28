package com.first1444.dashboard.advanced.implementations.chooser

import com.first1444.dashboard.ActiveComponent
import com.first1444.dashboard.ActiveComponentMultiplexer
import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.advanced.Sendable
import com.first1444.dashboard.advanced.SendableHelper
import com.first1444.dashboard.value.BasicValue
import com.first1444.dashboard.value.ValueProperty
import com.first1444.dashboard.value.implementations.PropertyActiveComponent
import java.util.concurrent.atomic.AtomicInteger


class ChooserSendable
/**
 * Creates a [ChooserSendable]
 * @param chooserProvider The [ChooserProvider] which is used to provide and set values
 * @param instanceNumber The instance number. If you override this, you should make this a large value so it doesn't conflict
 */
@JvmOverloads
constructor(
        private val chooserProvider: ChooserProvider,
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

    override fun init(title: String, dashboard: BasicDashboard): ActiveComponent {
        SendableHelper(dashboard)
                .setType("String Chooser")
        dashboard[INSTANCE].strictSetter.setDouble(instanceNumber.toDouble())

        return ActiveComponentMultiplexer(title, listOf(
                PropertyActiveComponent("", dashboard[DEFAULT], ValueProperty.createGetOnly { BasicValue.makeString(chooserProvider.defaultKey) }),
                PropertyActiveComponent("", dashboard[OPTIONS], ValueProperty.createGetOnly { BasicValue.makeStringArray(chooserProvider.keys.toTypedArray()) }),
                PropertyActiveComponent("", dashboard[ACTIVE], ValueProperty.createGetOnly { BasicValue.makeString(chooserProvider.selectedKey) }),
                PropertyActiveComponent("", dashboard[SELECTED], ValueProperty.create({ BasicValue.makeString(chooserProvider.selectedKey) }, { chooserProvider.selectedKey = it.value as String }))
        ))
    }

}
