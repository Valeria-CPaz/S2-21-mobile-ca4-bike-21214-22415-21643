package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

/*

DORSET COLLEGE

OBJECT ORIENTED PROGRAMING - CA3

Lecturer: John Rowley

STUDENTS:
Marcus Vinicius de Freitas Moura – 22415
Valeria Cardoso da Paz – 21214
Alexson Oliveira Silva – 21643




 */


// Data class that holds Dublin and Paris bikes variables references
data class BikesModels(
    val address: String,
    val available_bike_stands: Int,
    val available_bikes: Int,
    val bike_stands: Int,
    val last_update: Long,
    val name: String,
    val status: String,
//    val position: String
)

data class Position(
    val position : Double )









