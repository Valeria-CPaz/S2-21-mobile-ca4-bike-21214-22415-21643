package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dublin_bike.*

class JCDecauxBikeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_j_c_decaux_bike)

        //https://public.opendatasoft.com/api/records/1.0/search/?dataset=jcdecaux-bike-stations-data-rt&q=&facet=banking&facet=bonus&facet=status&facet=contract_name

        btnHome.setOnClickListener {
            Intent(this, MenuActivity::class.java).also {
                startActivity(it)
            }
        }
    }


}