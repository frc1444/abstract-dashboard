package com.first1444.dashboard.shuffleboard

import com.first1444.dashboard.BasicDashboard

interface MetadataEditor {
    fun editMetadata(metadataDashboard: BasicDashboard)
    companion object {
        @JvmField
        val NOTHING = MetadataEditor {}

        operator fun invoke(lambda: (metadataDashboard: BasicDashboard) -> Unit) = object : MetadataEditor {
            override fun editMetadata(metadataDashboard: BasicDashboard) {
                lambda(metadataDashboard)
            }
        }
    }
}
