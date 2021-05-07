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


import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnDublinBike.setOnClickListener {
            Intent(this, DublinBikeActivity::class.java).also {
                startActivity(it)
            }
        }
        btnParisBike.setOnClickListener {
            Intent(this, JCDecauxBikeActivity::class.java).also {
                startActivity(it)
            }
        }
        btnDublinWeather.setOnClickListener {
            Intent(this, DublinWeatherActivity::class.java).also {
                startActivity(it)
            }
        }
        btnParisWeather.setOnClickListener {
            Intent(this, ParisWeatherActivity::class.java).also {
                startActivity(it)
            }
        }

    }


}