package com.first1444.dashboard

interface Dashboard {
    fun delete(key: String)
    fun delete(data: DashboardData)

    fun putData(key: String, data: DashboardData)
    fun getData(key: String): DashboardData
}
