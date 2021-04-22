package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dublin_bike.*

class DublinBikeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dublin_bike)

        //api.jcdecaux.com/vls/v1/stations?contract={contract_name}&apiKey={api_key}

        // 8c0421336bf19ae390c470eb7858662f82772d84


        btnHome.setOnClickListener {
            Intent(this, MenuActivity::class.java).also {
                startActivity(it)
            }
        }

        // Favourites Dialog

        val addFavouritesDialog = AlertDialog.Builder(this)
            .setTitle("Add to Favourites")
            .setMessage("Do you want to add this station to your Favourites List?")
            .setIcon(R.drawable.ic_favourites)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(
                    this, "You added this station to your Favourites List",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(
                    this,
                    "You did not add this station to your Favourites List",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()


    }


}