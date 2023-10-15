package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.adapter.DriverTripRecyclerAdapter
import com.example.toping.service.MenuHandlerDriver
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_driver_home.*
import kotlinx.android.synthetic.main.activity_driver_trip.*
import kotlinx.android.synthetic.main.activity_driver_trip.drawerLayoutDriver
import kotlinx.android.synthetic.main.activity_home.navigationView
import kotlinx.android.synthetic.main.custom_top.*

class DriverTripActivity : AppCompatActivity() {

    private var layoutManagerTrip: RecyclerView.LayoutManager? = null
    private var adapterTrip: RecyclerView.Adapter<DriverTripRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_trip)
        Tools().whiteStatusBar(this, window)
        MenuHandlerDriver(this, navigationView, drawerLayoutDriver,"DriverTripActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvHeading.text = "Yolculuklarım"
        cardBack.setOnClickListener {
            finish()
        }

        layoutManagerTrip = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rvTripDriver.layoutManager = layoutManagerTrip

        adapterTrip = DriverTripRecyclerAdapter()
        rvTripDriver.adapter = adapterTrip

    }
}