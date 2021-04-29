package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_dublin_bike.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DublinBikeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dublin_bike)

        // Home Button
        btnHome.setOnClickListener {
            Intent(this, MenuActivity::class.java).also {
                startActivity(it)
            }
        }

        btnGoMap.setOnClickListener {
            Intent(this, MapsActivity::class.java).also {
                startActivity(it)
            }
        }

        DublinBikesApi().getBikes().enqueue(object: Callback<List<BikesModels>>{
            override fun onResponse(
                call: Call<List<BikesModels>>,
                response: Response<List<BikesModels>>) {
                val bikes = response.body()
                bikes?.let {
                    showBikes(it)
                }
            }

            override fun onFailure(call: Call<List<BikesModels>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun showBikes(bikesModels: List<BikesModels>) {
        // linking my ReclyclerView
        rvBikes.layoutManager = LinearLayoutManager(this)
        rvBikes.adapter = DublinBikeAdapter(bikesModels)

    }

}
// setup Android Networking

//


// Favourites Dialog

//        val addFavouritesDialog = AlertDialog.Builder(this)
//            .setTitle("Add to Favourites")
//            .setMessage("Do you want to add this station to your Favourites List?")
//            .setIcon(R.drawable.ic_favourites)
//            .setPositiveButton("Yes") { _, _ ->
//                Toast.makeText(
//                    this, "You added this station to your Favourites List",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            .setNegativeButton("No") { _, _ ->
//                Toast.makeText(
//                    this,
//                    "You did not add this station to your Favourites List",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }.create()
