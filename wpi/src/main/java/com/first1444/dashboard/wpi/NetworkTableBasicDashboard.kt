package com.first1444.dashboard.wpi

import com.first1444.dashboard.BasicDashboard
import com.first1444.dashboard.value.BasicEntry
import edu.wpi.first.networktables.NetworkTable

class NetworkTableBasicDashboard(
        private val networkTable: NetworkTable
) : BasicDashboard {

    private val tableCache = HashMap<String, BasicDashboard>()
    private val entryCache = HashMap<String, BasicEntry>()

    override fun getSubDashboard(key: String): BasicDashboard {
        return tableCache.getOrPut(key) {
            NetworkTableBasicDashboard(networkTable.getSubTable(key))
        }
    }

    override fun delete(key: String) {
        networkTable.delete(key)
    }

    override fun get(key: String): BasicEntry {
        return entryCache.getOrPut(key) {
            NetworkTableBasicEntry(networkTable.getEntry(key))
        }
    }

}
