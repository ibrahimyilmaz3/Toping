package com.example.toping.ui.activity

import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.example.toping.R
import com.example.toping.adapter.InfoAdapter
import com.example.toping.service.MenuHandler
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.BrandFragment
import com.example.toping.ui.dialog.ServiceFragment
import com.example.toping.util.BaseAppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_home.*


class  HomeActivity : BaseAppCompatActivity() {

    private var mapFragment: SupportMapFragment? = null

    private var backPressedOnce = false
    private var doubleBackPressedTime: Long = 0

    private var selected = -1

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END)
        } else {
            if (backPressedOnce) {
                val currentTime = System.currentTimeMillis()
                if (currentTime - doubleBackPressedTime < 2000) {
                    super.onBackPressed()
                } else {
                    backPressedOnce = false
                }
            } else {
                backPressedOnce = true
                doubleBackPressedTime = System.currentTimeMillis()
                Toast.makeText(this, "Çıkış yapmak için tekrar dokunun", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Tools().whiteStatusBar(this, window)
        MenuHandler(this, navigationView, drawerLayout, "HomeActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        cardMenu.setOnClickListener { drawerLayout.openDrawer(GravityCompat.END) }

        click()
        setupMap()

        linearPicture.visibility = View.GONE
        linearPicture.setOnClickListener {

            when (selected) {
                0 -> {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("name", "Tarihi Yerler Turu")
                    startActivity(intent)
                }
                1 -> {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("name", "Şehir Turu")
                    startActivity(intent)
                }
            }
        }

        btnRequest.setOnClickListener {
            val serviceFragment = ServiceFragment()
            serviceFragment.show(supportFragmentManager, "serviceFragment")
        }

    }

    private fun setupMap() {
        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment?
        mapFragment!!.getMapAsync { googleMap ->


            //googleMap.cameramo
            //Implement marker listener here!!!

            val locOne = LatLng(40.690273078603695, 39.65911373001713) //sümela
            val locTwo = LatLng(40.92481174152038, 40.21622918017668) //çamburnu
            val locThree = LatLng(40.996830678938586, 39.731281406225584) //atatürk
            val locFour = LatLng(41.00315230323957, 39.69611082883621) //Hagia Sophia
            val locFive = LatLng(40.99966600435516, 39.76053513897536) //Forum

            val markerView = (getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.marker_layout, null
            )
            googleMap.setInfoWindowAdapter(InfoAdapter(this))
            val linearMarker = markerView.findViewById<LinearLayout>(R.id.linearMarker)

            //Sümela Manastırı
            val bitmap1 = Bitmap.createScaledBitmap(
                viewToBitmap(linearMarker)!!,
                linearMarker.width,
                linearMarker.height,
                false
            )
            val smallerMarkerIcon1 = BitmapDescriptorFactory.fromBitmap(bitmap1)
            googleMap.addMarker(
                MarkerOptions().position(locOne).icon(smallerMarkerIcon1).title("Tarihi Yerler Turu")
            )
            //marker1?.tag = "Sümela Manastırı"

            //Çamburnu Doğa Parkı
            val bitmap2 = Bitmap.createScaledBitmap(
                viewToBitmap(linearMarker)!!,
                linearMarker.width,
                linearMarker.height,
                false
            )
            val smallerMarkerIcon2 = BitmapDescriptorFactory.fromBitmap(bitmap2)
            googleMap.addMarker(
                MarkerOptions().position(locTwo).icon(smallerMarkerIcon2)
                    .title("Şehir Turu")
            )

            //Atatürk Müzesi
            val bitmap3 = Bitmap.createScaledBitmap(
                viewToBitmap(linearMarker)!!,
                linearMarker.width,
                linearMarker.height,
                false
            )
            val smallerMarkerIcon3 = BitmapDescriptorFactory.fromBitmap(bitmap3)
            googleMap.addMarker(
                MarkerOptions().position(locThree).icon(smallerMarkerIcon3).title("Tarihi Yerler Turu")
            )

            //Ayasofya Müzesi
            val bitmap4 = Bitmap.createScaledBitmap(
                viewToBitmap(linearMarker)!!,
                linearMarker.width,
                linearMarker.height,
                false
            )
            val smallerMarkerIcon4 = BitmapDescriptorFactory.fromBitmap(bitmap4)
            googleMap.addMarker(
                MarkerOptions().position(locFour).icon(smallerMarkerIcon4).title("Şehir Turu")
            )

            //Forum Trabzon
            val bitmap5 = Bitmap.createScaledBitmap(
                viewToBitmap(linearMarker)!!,
                linearMarker.width,
                linearMarker.height,
                false
            )
            val smallerMarkerIcon5 = BitmapDescriptorFactory.fromBitmap(bitmap5)
            googleMap.addMarker(
                MarkerOptions().position(locFive).icon(smallerMarkerIcon5).title("Tarihi Yerler Turu")
            )
            val boundsBuilder = focus(locOne, locTwo, locThree, locFour, locFive)


            //val bounds = boundsBuilder.build()
            //val padding = 100 // Set the padding for the camera bounds
            //val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)
            //googleMap.moveCamera(cameraUpdate)

            googleMap.setOnMapLoadedCallback {
                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 200))
            }

            markerClick(googleMap)

            googleMap.setOnMapClickListener {
                linearPicture.visibility = View.GONE
                btnRequest.visibility = View.VISIBLE
            }

        }
    }

    private fun focus(
        locOne: LatLng,
        locTwo: LatLng,
        locThree: LatLng,
        locFour: LatLng,
        locFive: LatLng
    ): LatLngBounds.Builder {
        //focus camera on markers
        val markers = ArrayList<LatLng>()
        markers.add(locOne)
        markers.add(locTwo)
        markers.add(locThree)
        markers.add(locFour)
        markers.add(locFive)
        val boundsBuilder = LatLngBounds.Builder()
        for (marker in markers) {
            boundsBuilder.include(marker)
        }
        return boundsBuilder
    }

    private fun markerClick(googleMap: GoogleMap) {
        googleMap.setOnMarkerClickListener {
            btnRequest.visibility = View.GONE
            linearPicture.visibility = View.VISIBLE
            it.showInfoWindow()

            val cameraPosition = CameraPosition.Builder()
                .target(it.position)
                .zoom(10f)
                .build()
            val camUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
            googleMap.animateCamera(camUpdate)

            when (it.title) {
                "Tarihi Yerler Turu" -> {
                    selected = 0
                    ivFirst.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.sumela1
                        )
                    )
                    ivSecond.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.sumela2
                        )
                    )
                }
                "Doğa Turu" -> {
                    ivFirst.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.camburnu1
                        )
                    )
                    ivSecond.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.camburnu2
                        )
                    )
                }
                "Müze Turu" -> {
                    ivFirst.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.ataturk1
                        )
                    )
                    ivSecond.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.ataturk2
                        )
                    )
                }
                "Antik Yapılar Turu" -> {
                    ivFirst.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.museum1
                        )
                    )
                    ivSecond.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.museum2
                        )
                    )
                }
                "Şehir Turu" -> {
                    selected = 1
                    ivFirst.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.mall1
                        )
                    )
                    ivSecond.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.mall2
                        )
                    )
                }
            }

            //Toast.makeText(this, "${it.position}", Toast.LENGTH_SHORT).show()
            return@setOnMarkerClickListener true

        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun click() {
        cardNotifications.setOnClickListener {
            val intent1 = Intent(this, NotificationsActivity::class.java)
            startActivity(intent1)
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

    /*private fun showDialogVehicle() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_see_vehicle_detail)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val btnChoose = dialog.findViewById(R.id.btnSeeDetails) as Button
        btnChoose.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }*/

}