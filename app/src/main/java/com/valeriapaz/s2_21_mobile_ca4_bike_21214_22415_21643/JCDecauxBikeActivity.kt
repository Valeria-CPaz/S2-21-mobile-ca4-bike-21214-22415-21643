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
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_dublin_bike.btnHome
import kotlinx.android.synthetic.main.activity_j_c_decaux_bike.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JCDecauxBikeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_j_c_decaux_bike)

        // Home Button
        btnHome.setOnClickListener {
            Intent(this, MenuActivity::class.java).also {
                startActivity(it)
            }
        }

        btnGoMapParis.setOnClickListener {
            Intent(this, ParisMapsActivity::class.java).also {
                startActivity(it)
            }
        }

        ParisBikesApi().getBikes().enqueue(object: Callback<List<BikesModels>> {
            override fun onResponse(
                call: Call<List<BikesModels>>,
                response: Response<List<BikesModels>>
            ) {
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

    private fun showBikes(bikesModelsParis: List<BikesModels>) {
        // linking my ReclyclerView
        rvBikesParis.layoutManager = LinearLayoutManager(this)
        rvBikesParis.adapter = ParisBikeAdapter(bikesModelsParis)

    }

}