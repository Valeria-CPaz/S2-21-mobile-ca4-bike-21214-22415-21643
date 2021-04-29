package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_dublin_bike.*
import kotlinx.android.synthetic.main.item_bike.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL

class MapsActivity : BaseActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


//    val dublin = LatLng(53.3498, -6.2603)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        val test = LatLng(53.3498, -6.2603)


//        for (i in markersList!!) {
//            val marker = LatLng(i.lat, i.lng)
//            mMap.addMarker(MarkerOptions().position(marker).title("teste"))
//
//        }

//         Add a marker in Sydney and move the camera
        mMap.addMarker(MarkerOptions().position(test).title("Test"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(test, 13f))

        mMap.uiSettings.isMyLocationButtonEnabled = true
        mMap.isMyLocationEnabled

    }

//    fun teste(bikesList: List<Position>, position: Int) {
//
//        val bike = bikesList[position]
//
////        val markerTeste = bike

    }




