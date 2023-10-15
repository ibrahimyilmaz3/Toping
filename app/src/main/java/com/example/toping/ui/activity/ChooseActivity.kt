package com.example.toping.ui.activity

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.`object`.Route.navRoute
import com.example.toping.`object`.Route.route
import com.example.toping.adapter.ChooseAdapter
import com.example.toping.model.Choose
import com.example.toping.model.Route
import com.example.toping.service.Tools
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import kotlinx.android.synthetic.main.activity_choose.*
import java.util.*

class ChooseActivity : AppCompatActivity(), OnMapReadyCallback {

    /*for (i in route) {
        if (i.latLng != null) {
            drawMarker(i.latLng)
        }
    }*/


    val choose = ArrayList<Choose>()
    private val choose2 = ArrayList<Choose>()

    var currentMarker: Marker? = null
    private lateinit var mMap: GoogleMap
    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    var currentLocation: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        dataInitialize()

        search()

        rvChoose.layoutManager = LinearLayoutManager(this)
        val chooseAdapter = ChooseAdapter(choose2)
        rvChoose.adapter = chooseAdapter

        cardBack.setOnClickListener { finish() }

        cardConfirm.setOnClickListener {
            val latLong = currentLocation?.let { it1 ->
                currentLocation?.longitude?.let { it2 ->
                    LatLng(
                        it1.latitude,
                        it2
                    )
                }
            }
            when (navRoute) {
                1 -> {
                    route.removeAt(0)
                    route.add(0, Route(getAddress(currentMarker?.position), latLong))
                }
                2 -> {
                    route.add(route.size - 1, Route(getAddress(currentMarker?.position), latLong))
                }
                3 -> {
                    route.removeAt(route.size - 1)
                    route.add(route.size, Route(getAddress(currentMarker?.position), latLong))
                }
            }
            finish()
        }

        fetchLocation()

        ivGet.setOnClickListener {
            val myLocation = LatLng(currentLocation?.latitude!!, currentLocation?.longitude!!)
            currentMarker?.remove()
            drawMarker(myLocation)
        }

    }

    private fun search() {
        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, "AIzaSyBUJ5ZAPgQ2fg9NvMEtDHTLb-rMW3MlCSw")
        }

        // Initialize Autocomplete Fragments
        // from the main activity layout file
        val autocompleteSupportFragment1 =
            supportFragmentManager.findFragmentById(R.id.autocomplete_fragment1) as AutocompleteSupportFragment?

        // Information that we wish to fetch after typing
        // the location and clicking on one of the options
        autocompleteSupportFragment1!!.setPlaceFields(
            listOf(
                Place.Field.LAT_LNG
            )
        )

        // Display the fetched information after clicking on one of the options
        autocompleteSupportFragment1.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                val latlng = place.latLng
                currentMarker?.remove()
                drawMarker(latlng)

            }

            override fun onError(status: Status) {
                Toast.makeText(applicationContext, "Some error occurred", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun fetchLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1000
            )
            return
        }

        val task = fusedLocationProviderClient?.lastLocation
        task?.addOnSuccessListener { location ->
            if (location != null) {
                this.currentLocation = location
                val mapFragment = supportFragmentManager
                    .findFragmentById(R.id.map6) as SupportMapFragment
                mapFragment.getMapAsync(this)
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1000 -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLocation()
            }
        }
    }

    private fun dataInitialize() {
        choose.add(Choose("Örnek1 Mah. Deneme Sk. No:24/8 Trabzon"))
        choose.add(Choose("Örnek2 Mah. Deneme Sk. No:24/8 Trabzon"))
        choose.add(Choose("Örnek3 Mah. Deneme Sk. No:24/8 Trabzon"))
        choose.add(Choose("Örnek4 Mah. Deneme Sk. No:24/8 Trabzon"))
        choose.add(Choose("Örnek5 Mah. Deneme Sk. No:24/8 Trabzon"))
        choose.add(Choose("Örnek6 Mah. Deneme Sk. No:24/8 Trabzon"))
        choose.add(Choose("Örnek7 Mah. Deneme Sk. No:24/8 Trabzon"))
        choose.add(Choose("Örnek8 Mah. Deneme Sk. No:24/8 Trabzon"))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latlong = LatLng(currentLocation?.latitude!!, currentLocation?.longitude!!)
        drawMarker(latlong)

        mMap.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener {
            override fun onMarkerDrag(p0: Marker) {

            }

            override fun onMarkerDragEnd(p0: Marker) {
                if (currentMarker != null) currentMarker?.remove()

                val newLatLng = LatLng(p0.position.latitude, p0.position.longitude)
                drawMarker(newLatLng)
            }

            override fun onMarkerDragStart(p0: Marker) {

            }
        })

    }

    private fun drawMarker(latlong: LatLng) {

        mMap.setInfoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
            override fun getInfoWindow(p0: Marker): View? {
                val view =
                    LayoutInflater.from(this@ChooseActivity).inflate(R.layout.info_layout_2, null)
                val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
                val tvAddress = view.findViewById<TextView>(R.id.tvAddress)

                tvTitle.text = currentMarker?.title ?: ""
                tvAddress.text = getAddress(currentMarker?.position)

                return view

            }

            override fun getInfoContents(p0: Marker): View? {
                val view =
                    LayoutInflater.from(this@ChooseActivity).inflate(R.layout.info_layout_2, null)
                val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
                val tvAddress = view.findViewById<TextView>(R.id.tvAddress)

                tvTitle.text = currentMarker?.title ?: ""
                tvAddress.text = getAddress(currentMarker?.position)

                return view
            }
        })

        val markerView = LayoutInflater.from(this).inflate(R.layout.marker_layout, null)
        val markerOption = MarkerOptions().position(latlong).title("Konum").icon(
            BitmapDescriptorFactory.fromBitmap(getBitmapFromView(markerView))
        ).draggable(true)

        mMap.animateCamera(CameraUpdateFactory.newLatLng(latlong))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlong, 15f))
        currentMarker = mMap.addMarker(markerOption)
        currentMarker?.showInfoWindow()
    }

    private fun getBitmapFromView(view: View): Bitmap {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val bitmap =
            Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)
        return bitmap
    }

    private fun getTheAddress(latitude: Double, longitude: Double): String? {
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses = geocoder.getFromLocation(latitude, longitude, 1)
        if (addresses.size > 0)
            return addresses[0].getAddressLine(0)
        return ""
    }

    private fun getAddress(position: LatLng?): String {
        val geocoder = Geocoder(this@ChooseActivity, Locale.getDefault())
        val addresses =
            geocoder.getFromLocation(position?.latitude ?: 0.0, position?.longitude ?: 0.0, 1)
        return addresses.firstOrNull()?.getAddressLine(0) ?: ""
    }

}