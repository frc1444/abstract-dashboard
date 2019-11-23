package com.first1444.dashboard.wpi

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.value.BasicEntry
import edu.wpi.first.networktables.NetworkTableInstance

class NetworkTableInstanceBasicDashboard(
    private val networkTableInstance: NetworkTableInstance
) : BasicDashboard {

    private val tableCache = HashMap<String, BasicDashboard>()
    private val entryCache = HashMap<String, BasicEntry>()

    override fun getSubDashboard(key: String): BasicDashboard {
        return tableCache.getOrPut(key) {
            NetworkTableBasicDashboard(networkTableInstance.getTable(key))
        }
    }

    override fun delete(key: String) {
        networkTableInstance.getEntry(key).delete()
    }

    override fun get(key: String): BasicEntry {
        return entryCache.getOrPut(key) {
            NetworkTableBasicEntry(networkTableInstance.getEntry(key))
        }
    }
}
