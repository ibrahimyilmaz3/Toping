package com.example.toping.ui.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.toping.R
import com.example.toping.adapter.InfoAdapter
import com.example.toping.service.Tools
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_driver_trip_detail.*

class DriverTripDetailActivity : AppCompatActivity() {

    private var mapFragment: SupportMapFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_trip_detail)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setupMap()

        cardGoBack.setOnClickListener {
            finish()
        }
    }

    private fun setupMap() {
        mapFragment = supportFragmentManager.findFragmentById(R.id.map4) as? SupportMapFragment?
        mapFragment!!.getMapAsync { googleMap ->
            val locOne = LatLng(40.690273078603695, 39.65911373001713) //sümela
            val locTwo = LatLng(40.92481174152038, 40.21622918017668) //çamburnu

            val markerView = (getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.marker_layout, null
            )
            googleMap.setInfoWindowAdapter(InfoAdapter(this))
            val linearMarker = markerView.findViewById<LinearLayout>(R.id.linearMarker)

            val bitmap1 = Bitmap.createScaledBitmap(
                viewToBitmap(linearMarker)!!,
                linearMarker.width,
                linearMarker.height,
                false
            )
            val smallerMarkerIcon1 = BitmapDescriptorFactory.fromBitmap(bitmap1)
            googleMap.addMarker(
                MarkerOptions().position(locOne).icon(smallerMarkerIcon1).title("Sümela Manastırı")
            )
            //marker1?.tag = "Sümela Manastırı"

            val bitmap2 = Bitmap.createScaledBitmap(
                viewToBitmap(linearMarker)!!,
                linearMarker.width,
                linearMarker.height,
                false
            )
            val smallerMarkerIcon2 = BitmapDescriptorFactory.fromBitmap(bitmap2)
            googleMap.addMarker(
                MarkerOptions().position(locTwo).icon(smallerMarkerIcon2)
                    .title("Çamburnu Doğa Parkı")
            )

            val line = PolylineOptions()
                .add(locOne, locTwo)
                .width(5f)
                .color(ContextCompat.getColor(this, R.color.blue))
            // Add the Polyline to the map
            googleMap.addPolyline(line)

            //focus camera on markers
            val markers = ArrayList<LatLng>()
            markers.add(locOne)
            markers.add(locTwo)
            val boundsBuilder = LatLngBounds.Builder()
            for (marker in markers) {
                boundsBuilder.include(marker)
            }
            //val bounds = boundsBuilder.build()
            //val padding = 100 // Set the padding for the camera bounds
            //val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)
            //googleMap.moveCamera(cameraUpdate)

            googleMap.setOnMapLoadedCallback {
                googleMap.moveCamera(
                    CameraUpdateFactory.newLatLngBounds(
                        boundsBuilder.build(),
                        200
                    )
                )
            }

            googleMap.setOnMarkerClickListener {
                it.showInfoWindow()

                val cameraPosition = CameraPosition.Builder()
                    .target(it.position)
                    .zoom(10f)
                    .build()
                val camUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
                googleMap.animateCamera(camUpdate)

                //Toast.makeText(this, "${it.position}", Toast.LENGTH_SHORT).show()
                return@setOnMarkerClickListener true

            }

        }
    }

    private fun viewToBitmap(view: View): Bitmap? {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val bitmap =
            Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)
        return bitmap
    }
}