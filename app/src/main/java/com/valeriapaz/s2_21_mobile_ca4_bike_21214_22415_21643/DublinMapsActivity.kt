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


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
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
import java.util.*

class DublinMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val REQUEST_LOCATION_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun enableMyLocation() {
        if (isPermissionGranted()) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                return
            }
            mMap.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()
            }
        }
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

        val dublin_42 = LatLng(53.349562, -6.278198)
        val dublin_30 = LatLng(53.353462, -6.265305)
        val dublin_54 = LatLng(53.336021, -6.26298)
        val dublin_108 = LatLng(53.359405, -6.276142)
        val dublin_56 = LatLng(53.33796, -6.24153)
        val dublin_6 = LatLng(53.343368, -6.27012)
        val dublin_18 = LatLng(53.334123, -6.265436)
        val dublin_32 = LatLng(53.344304, -6.250427)
        val dublin_52 = LatLng(53.338755, -6.262003)
        val dublin_48 = LatLng(53.347777, -6.244239)
        val dublin_13 = LatLng(53.36074, -6.252825)
        val dublin_43 = LatLng(53.330091, -6.268044)
        val dublin_31 = LatLng(53.350929, -6.265125)
        val dublin_98 = LatLng(53.341515, -6.256853)
        val dublin_23 = LatLng(53.348279, -6.254662)
        val dublin_106 = LatLng(53.35893, -6.280337)
        val dublin_112 = LatLng(53.357841, -6.251557)
        val dublin_68 = LatLng(53.344115, -6.237153)
        val dublin_74 = LatLng(53.343893, -6.280531)
        val dublin_87 = LatLng(53.347477, -6.28525)
        val dublin_84 = LatLng(53.339005, -6.300217)
        val dublin_90 = LatLng(53.344153, -6.233451)
        val dublin_11 = LatLng(53.334295, -6.258503)
        val dublin_17 = LatLng(53.340803, -6.267732)
        val dublin_45 = LatLng(53.351464, -6.255265)
        val dublin_114 = LatLng(53.333653, -6.248345)
        val dublin_72 = LatLng(53.343105, -6.277167)
        val dublin_63 = LatLng(53.341428, -6.24672)
        val dublin_113 = LatLng(53.338614, -6.248606)
        val dublin_91 = LatLng(53.341833, -6.231291)
        val dublin_99 = LatLng(53.346637, -6.246154)
        val dublin_9 = LatLng(53.343034, -6.263578)
        val dublin_67 = LatLng(53.346867, -6.230852)
        val dublin_116 = LatLng(53.3547, -6.272314)
        val dublin_55 = LatLng(53.33403, -6.260714)
        val dublin_62 = LatLng(53.346026, -6.243576)
        val dublin_5 = LatLng(53.330662, -6.260177)
        val dublin_97 = LatLng(53.342113, -6.310015)
        val dublin_61 = LatLng(53.357043, -6.263232)
        val dublin_77 = LatLng(53.348875, -6.267459)
        val dublin_73 = LatLng(53.342081, -6.342081)
        val dublin_4 = LatLng(53.346874, -6.272976)
        val dublin_49 = LatLng(53.347932, -6.240928)
        val dublin_19 = LatLng(53.334432, -6.245575)
        val dublin_7 = LatLng(53.343565, -6.275071)
        val dublin_102 = LatLng(53.354929, -6.269425)
        val dublin_38 = LatLng(53.350974, -6.25294)
        val dublin_53 = LatLng(53.337132, -6.26059)
        val dublin_58 = LatLng(53.339218, -6.240642)
        val dublin_66 = LatLng(53.347122, -6.234749)
        val dublin_104 = LatLng(53.355173, -6.278424)
        val dublin_101 = LatLng(53.350291, -6.273507)
        val dublin_115 = LatLng(53.354845, -6.247579)
        val dublin_47 = LatLng(53.335742, -6.24551)
        val dublin_117 = LatLng(53.343653, -6.231755)
        val dublin_8 = LatLng(53.347884, -6.248048)
        val dublin_27 = LatLng(53.341288, -6.258117)
        val dublin_16 = LatLng(53.347508, -6.252192)
        val dublin_96 = LatLng(53.341805, -6.305085)
        val dublin_82 = LatLng(53.341645, -6.29719)
        val dublin_76 = LatLng(53.342296, -6.287661)
        val dublin_71 = LatLng(53.337757, -6.267699)
        val dublin_79 = LatLng(53.358115, -6.265601)
        val dublin_69 = LatLng(53.342638, -6.238695)
        val dublin_25 = LatLng(53.339434, -6.246548)
        val dublin_51 = LatLng(53.339334, -6.264699)
        val dublin_37 = LatLng(53.337494, -6.26199)
        val dublin_59 = LatLng(53.35561, -6.261397)
        val dublin_95 = LatLng(53.343897, -6.29706)
        val dublin_94 = LatLng(53.346985, -6.297804)
        val dublin_105 = LatLng(53.355954, -6.278378)
        val dublin_36 = LatLng(53.337824, -6.256035)
        val dublin_93 = LatLng(53.346603, -6.296924)
        val dublin_22 = LatLng(53.345922, -6.254614)
        val dublin_50 = LatLng(53.35023, -6.279696)
        val dublin_110 = LatLng(53.356307, -6.273717)
        val dublin_12 = LatLng(53.359246, -6.269779)
        val dublin_34 = LatLng(53.330362, -6.265163)
        val dublin_78 = LatLng(53.359967, -6.264828)
        val dublin_2 = LatLng(53.356769, -6.26814)
        val dublin_75 = LatLng(53.343456, -6.287409)
        val dublin_111 = LatLng(53.356717, -6.256359)
        val dublin_26 = LatLng(53.339764, -6.251988)
        val dublin_65 = LatLng(53.34744, -6.238523)
        val dublin_15 = LatLng(53.355473, -6.264423)
        val dublin_86 = LatLng(53.347972, -6.291804)
        val dublin_10 = LatLng(53.344007, -6.266802)
        val dublin_100 = LatLng(53.347106, -6.292041)
        val dublin_24 = LatLng(53.352149, -6.260533)
        val dublin_64 = LatLng(53.345203, -6.247163)
        val dublin_109 = LatLng(53.353331, -6.249319)
        val dublin_85 = LatLng(53.338776, -6.30395)
        val dublin_107 = LatLng(53.359157, -6.281866)
        val dublin_33 = LatLng(53.349013, -6.260311)
        val dublin_44 = LatLng(53.358437, -6.260641)
        val dublin_89 = LatLng(53.335211, -6.2509)
        val dublin_57 = LatLng(53.339629, -6.243778)
        val dublin_80 = LatLng(53.341359, -6.292951)
        val dublin_41 = LatLng(53.332763, -6.257942)
        val dublin_3 = LatLng(53.351182, -6.269859)
        val dublin_40 = LatLng(53.3483, -6.266651)
        val dublin_29 = LatLng(53.346057, -6.268001)
        val dublin_103 = LatLng(53.354663, -6.278681)
        val dublin_28 = LatLng(53.356299, -6.258586)
        val dublin_39 = LatLng(53.332383, -6.252717)
        val dublin_83 = LatLng(53.340714, -6.308191)
        val dublin_92 = LatLng(53.347802, -6.292432)
        val dublin_21 = LatLng(53.34218, -6.254485)
        val dublin_88 = LatLng(53.3488, -6.281637)

//    Markers
        mMap.addMarker(MarkerOptions().position(dublin_42).title("SMITHFIELD NORTH"))
        mMap.addMarker(MarkerOptions().position(dublin_30).title("PARNELL SQUARE NORTH"))
        mMap.addMarker(MarkerOptions().position(dublin_54).title("CLONMEL STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_108).title("AVONDALE ROAD"))
        mMap.addMarker(MarkerOptions().position(dublin_56).title("MOUNT STREET LOWER"))
        mMap.addMarker(MarkerOptions().position(dublin_6).title("CHRISTCHURCH PLACE"))
        mMap.addMarker(MarkerOptions().position(dublin_18).title("GRANTHAM STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_32).title("PEARSE STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_52).title("YORK STREET EAST"))
        mMap.addMarker(MarkerOptions().position(dublin_48).title("EXCISE WALK"))
        mMap.addMarker(MarkerOptions().position(dublin_13).title("FITZWILLIAM SQUARE WEST"))
        mMap.addMarker(MarkerOptions().position(dublin_43).title("PORTOBELLO ROAD"))
        mMap.addMarker(MarkerOptions().position(dublin_31).title("PARNELL STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_98).title("FREDERICK STREET SOUTH"))
        mMap.addMarker(MarkerOptions().position(dublin_23).title("CUSTOM HOUSE"))
        mMap.addMarker(MarkerOptions().position(dublin_106).title("RATHDOWN ROAD"))
        mMap.addMarker(MarkerOptions().position(dublin_112).title("NORTH CIRCULAR ROAD (O'CONNELL'S)"))
        mMap.addMarker(MarkerOptions().position(dublin_68).title("HANOVER QUAY"))
        mMap.addMarker(MarkerOptions().position(dublin_74).title("OLIVER BOND STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_87).title("COLLINS BARRACKS MUSEUM"))
        mMap.addMarker(MarkerOptions().position(dublin_84).title("BROOKFIELD ROAD"))
        mMap.addMarker(MarkerOptions().position(dublin_90).title("BENSON STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_11).title("EARLSFORT TERRACE"))
        mMap.addMarker(MarkerOptions().position(dublin_17).title("GOLDEN LANE"))
        mMap.addMarker(MarkerOptions().position(dublin_45).title("DEVERELL PLACE"))
        mMap.addMarker(MarkerOptions().position(dublin_114).title("WILTON TERRACE (PARK)"))
        mMap.addMarker(MarkerOptions().position(dublin_72).title("JOHN STREET WEST"))
        mMap.addMarker(MarkerOptions().position(dublin_63).title("FENIAN STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_113).title("MERRION SQUARE SOUTH"))
        mMap.addMarker(MarkerOptions().position(dublin_91).title("SOUTH DOCK ROAD"))
        mMap.addMarker(MarkerOptions().position(dublin_99).title("CITY QUAY"))
        mMap.addMarker(MarkerOptions().position(dublin_9).title("EXCHEQUER STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_67).title("THE POINT"))
        mMap.addMarker(MarkerOptions().position(dublin_116).title("BROADSTONE"))
        mMap.addMarker(MarkerOptions().position(dublin_55).title("HATCH STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_62).title("LIME STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_5).title("CHARLEMONT PLACE"))
        mMap.addMarker(MarkerOptions().position(dublin_97).title("KILMAINHAM GAOL"))
        mMap.addMarker(MarkerOptions().position(dublin_61).title("HARDWICKE PLACE"))
        mMap.addMarker(MarkerOptions().position(dublin_77).title("WOLFE TONE STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_73).title("FRANCIS STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_4).title("GREEK STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_49).title("GUILD STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_19).title("HERBERT PLACE"))
        mMap.addMarker(MarkerOptions().position(dublin_7).title("HIGH STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_102).title("WESTERN WAY"))
        mMap.addMarker(MarkerOptions().position(dublin_38).title("TALBOT STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_53).title("NEWMAN HOUSE"))
        mMap.addMarker(MarkerOptions().position(dublin_58).title("SIR PATRICK DUN'S"))
        mMap.addMarker(MarkerOptions().position(dublin_66).title("NEW CENTRAL BANK"))
        mMap.addMarker(MarkerOptions().position(dublin_104).title("GRANGEGORMAN LOWER (CENTRAL)"))
        mMap.addMarker(MarkerOptions().position(dublin_101).title("KING STREET NORTH"))
        mMap.addMarker(MarkerOptions().position(dublin_115).title("KILLARNEY STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_47).title("HERBERT STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_117).title("HANOVER QUAY EAST"))
        mMap.addMarker(MarkerOptions().position(dublin_8).title("CUSTOM HOUSE QUAY"))
        mMap.addMarker(MarkerOptions().position(dublin_27).title("MOLESWORTH STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_16).title("GEORGES QUAY"))
        mMap.addMarker(MarkerOptions().position(dublin_96).title("KILMAINHAM LANE"))
        mMap.addMarker(MarkerOptions().position(dublin_82).title("MOUNT BROWN"))
        mMap.addMarker(MarkerOptions().position(dublin_76).title("MARKET STREET SOUTH"))
        mMap.addMarker(MarkerOptions().position(dublin_71).title("KEVIN STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_79).title("ECCLES STREET EAST"))
        mMap.addMarker(MarkerOptions().position(dublin_69).title("GRAND CANAL DOCK"))
        mMap.addMarker(MarkerOptions().position(dublin_25).title("MERRION SQUARE EAST"))
        mMap.addMarker(MarkerOptions().position(dublin_51).title("YORK STREET WEST"))
        mMap.addMarker(MarkerOptions().position(dublin_37).title("ST. STEPHEN'S GREEN SOUTH"))
        mMap.addMarker(MarkerOptions().position(dublin_59).title("DENMARK STREET GREAT"))
        mMap.addMarker(MarkerOptions().position(dublin_95).title("ROYAL HOSPITAL"))
        mMap.addMarker(MarkerOptions().position(dublin_94).title("HEUSTON STATION (CAR PARK)"))
        mMap.addMarker(MarkerOptions().position(dublin_105).title("GRANGEGORMAN LOWER (NORTH)"))
        mMap.addMarker(MarkerOptions().position(dublin_36).title("ST. STEPHEN'S GREEN EAST"))
        mMap.addMarker(MarkerOptions().position(dublin_93).title("HEUSTON STATION (CENTRAL)"))
        mMap.addMarker(MarkerOptions().position(dublin_22).title("TOWNSEND STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_50).title("GEORGES LANE"))
        mMap.addMarker(MarkerOptions().position(dublin_110).title("PHIBSBOROUGH ROAD"))
        mMap.addMarker(MarkerOptions().position(dublin_12).title("ECCLES STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_34).title("PORTOBELLO HARBOUR"))
        mMap.addMarker(MarkerOptions().position(dublin_78).title("MATER HOSPITAL"))
        mMap.addMarker(MarkerOptions().position(dublin_2).title("BLESSINGTON STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_75).title("JAMES STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_111).title("MOUNTJOY SQUARE EAST"))
        mMap.addMarker(MarkerOptions().position(dublin_26).title("MERRION SQUARE WEST"))
        mMap.addMarker(MarkerOptions().position(dublin_65).title("CONVENTION CENTRE"))
        mMap.addMarker(MarkerOptions().position(dublin_15).title("HARDWICKE STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_86).title("PARKGATE STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_10).title("DAME STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_100).title("HEUSTON BRIDGE (SOUTH)"))
        mMap.addMarker(MarkerOptions().position(dublin_24).title("CATHAL BRUGHA STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_64).title("SANDWITH STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_109).title("BUCKINGHAM STREET LOWER"))
        mMap.addMarker(MarkerOptions().position(dublin_85).title("ROTHE ABBEY"))
        mMap.addMarker(MarkerOptions().position(dublin_107).title("CHARLEVILLE ROAD"))
        mMap.addMarker(MarkerOptions().position(dublin_33).title("PRINCES STREET / O'CONNELL STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_44).title("UPPER SHERRARD STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_89).title("FITZWILLIAM SQUARE EAST"))
        mMap.addMarker(MarkerOptions().position(dublin_57).title("GRATTAN STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_80).title("ST JAMES HOSPITAL (LUAS)"))
        mMap.addMarker(MarkerOptions().position(dublin_41).title("HARCOURT TERRACE"))
        mMap.addMarker(MarkerOptions().position(dublin_3).title("BOLTON STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_40).title("JERVIS STREET"))
        mMap.addMarker(MarkerOptions().position(dublin_29).title("ORMOND QUAY UPPER"))
        mMap.addMarker(MarkerOptions().position(dublin_103).title("GRANGEGORMAN LOWER (SOUTH)"))
        mMap.addMarker(MarkerOptions().position(dublin_28).title("MOUNTJOY SQUARE WEST"))
        mMap.addMarker(MarkerOptions().position(dublin_39).title("WILTON TERRACE"))
        mMap.addMarker(MarkerOptions().position(dublin_83).title("EMMET ROAD"))
        mMap.addMarker(MarkerOptions().position(dublin_92).title("HEUSTON BRIDGE (NORTH)"))
        mMap.addMarker(MarkerOptions().position(dublin_21).title("LEINSTER STREET SOUTH"))
        mMap.addMarker(MarkerOptions().position(dublin_88).title("BLACKHALL PLACE"))


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dublin_42, 12f))


        setMapLongClick(mMap)
        setPoiClick(mMap)
        enableMyLocation()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.maps_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        // Change the map type based on the user's selection.
        R.id.normal_map -> {
            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            true
        }
        R.id.hybrid_map -> {
            mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
            true
        }
        R.id.satellite_map -> {
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
            true
        }
        R.id.terrain_map -> {
            mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setMapLongClick(map: GoogleMap) {
        map.setOnMapLongClickListener { latLng ->

            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1$.5f, Long: %2$.5f",
                latLng.latitude,
                latLng.longitude
            )

            map.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(getString(R.string.dropped_pin))
                    .snippet(snippet)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))

            )

            // It is around here you grab and store coordinates
        }
    }

    private fun setPoiClick(map: GoogleMap) {
        map.setOnPoiClickListener { poi ->
            val poiMarker = map.addMarker(
                MarkerOptions()
                    .position(poi.latLng)
                    .title(poi.name)
            )
            poiMarker.showInfoWindow()
        }
    }


}



