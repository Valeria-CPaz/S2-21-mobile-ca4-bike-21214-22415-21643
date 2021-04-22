package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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