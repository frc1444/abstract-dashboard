package com.first1444.dashboard

interface DashboardData {
    val dashboardType: String
    val isActuator: Boolean
    val safeState: Runnable
    val updateTable: Runnable

}
