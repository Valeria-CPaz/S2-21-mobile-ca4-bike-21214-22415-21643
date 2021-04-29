package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_weather.*
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class DublinWeatherActivity : BaseActivity() {

    val CITY: String = "Dublin,IE"
    // Used of API key
    val API: String = "a12c3fe55e4ee95592dab383cfbefde5"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        // Button Home handle
        btnHome.setOnClickListener {
            Intent(this, MenuActivity::class.java).also {
                startActivity(it)
            }
        }

        // Calling Function
        weatherTask().execute()

    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            // Showing the ProgressBar, Making the main design GONE
            pbLoader.visibility = View.VISIBLE
            tvErrorText.visibility = View.GONE
        }

        override fun doInBackground(vararg params: String?): String? {
            var response:String?
            try{
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API").readText(
                    Charsets.UTF_8
                )
            }catch (e: Exception){
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                // Extracting JSON from the API
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)

                val updatedAt:Long = jsonObj.getLong("dt")
                val updatedAtText = "Updated at: "+ SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(Date(updatedAt*1000))
                val temp = main.getString("temp")+"°C"
                val tempMin = "Min Temp: " + main.getString("temp_min")+"°C"
                val tempMax = "Max Temp: " + main.getString("temp_max")+"°C"
                val pressure = main.getString("pressure")+" psi"
                val humidity = main.getString("humidity")+" %"

                val sunrise:Long = sys.getLong("sunrise")
                val sunset:Long = sys.getLong("sunset")
                val windSpeed = wind.getString("speed")+" km/h"
                val weatherDescription = weather.getString("description")

                val address = jsonObj.getString("name")+", "+sys.getString("country")

                // Populating extracted data into our views
                tvLocation.text = address
                tvUpdatedAt.text = updatedAtText
                tvStatus.text = weatherDescription.capitalize(Locale.ROOT)
                tvTemperature.text = temp
                tvMinTemp.text = tempMin
                tvMaxTemp.text = tempMax
                tvSunriseTime.text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise*1000))
                tvSunsetTime.text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset*1000))
                tvWindTime.text = windSpeed
                tvPressureTime.text = pressure
                tvHumidityTime.text = humidity

                // Views populated, Hiding the loader, Showing the main design
                findViewById<ProgressBar>(R.id.pbLoader).visibility = View.GONE

            } catch (e: Exception) {
                findViewById<ProgressBar>(R.id.pbLoader).visibility = View.GONE
                findViewById<TextView>(R.id.tvErrorText).visibility = View.VISIBLE
            }

        }
    }

}