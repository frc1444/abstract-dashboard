package com.first1444.dashboard.shuffleboard

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.value.BasicValue

/**
 * NOTE: When using this, you must specify both the size and position for positioning to work correctly.
 */
class ComponentMetadataHelper(
        private val metadataDashboard: BasicDashboard
) {
    fun setName(name: String): ComponentMetadataHelper {
        metadataDashboard[".name"].strictSetter.setString(name)
        return this
    }

    /**
     * Sets the shuffleboard type
     */
    fun setType(type: String): ComponentMetadataHelper {
        metadataDashboard[".type"].strictSetter.setString(type)
        return this
    }

    /**
     * Sets the preferred type. AKA the SmartDashboard type
     */
    fun setPreferredComponent(type: String): ComponentMetadataHelper {
        metadataDashboard["PreferredComponent"].strictSetter.setString(type)
        return this
    }
    fun clearPreferredComponent(): ComponentMetadataHelper {
        metadataDashboard["PreferredComponent"].delete()
        return this
    }

    fun clearSize(): ComponentMetadataHelper {
        metadataDashboard["Size"].delete()
        return this
    }
    fun setSize(width: Int, height: Int): ComponentMetadataHelper {
        metadataDashboard["Size"].strictSetter.setDoubleArray(doubleArrayOf(width.toDouble(), height.toDouble()))
        return this
    }
    fun clearPosition(): ComponentMetadataHelper {
        metadataDashboard["Position"].delete()
        return this
    }
    fun setPosition(column: Int, row: Int): ComponentMetadataHelper {
        metadataDashboard["Position"].strictSetter.setDoubleArray(doubleArrayOf(column.toDouble(), row.toDouble()))
        return this
    }
    fun setProperties(properties: Map<String, BasicValue>): ComponentMetadataHelper {
        val propertiesDashboard = metadataDashboard.getSubDashboard("Properties")
        for((name, value) in properties.entries){
            propertiesDashboard[name].strictSetter.set(value)
        }
        return this
    }
}
