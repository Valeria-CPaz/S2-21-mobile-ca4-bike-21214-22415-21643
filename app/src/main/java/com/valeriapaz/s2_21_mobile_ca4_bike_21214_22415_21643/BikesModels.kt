package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.os.Bundle

// Data class that holds Dublin and Paris bikes variables references
data class BikesModels(
    val address: String,
    val available_bike_stands: Int,
    val available_bikes: Int,
    val bike_stands: Int,
    val last_update: Long,
    val name: String,
    val status: String,
    val positionLL: List<Position>
)

data class Position(val lat: Double, val lng: Double)








