package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.adapter.TripRecyclerAdapter
import com.example.toping.service.MenuHandler
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_trip.*
import kotlinx.android.synthetic.main.custom_top.*

class TripActivity : AppCompatActivity() {

    private var layoutManagerTrip: RecyclerView.LayoutManager? = null
    private var adapterTrip: RecyclerView.Adapter<TripRecyclerAdapter.ViewHolder>? = null

    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip)
        Tools().whiteStatusBar(this, window)
        MenuHandler(this, navigationView, drawerLayout, "TripActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvHeading.text = getString(R.string.trips)
        cardBack.setOnClickListener {
            finish()
        }

        layoutManagerTrip = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rvNotifications.layoutManager = layoutManagerTrip

        adapterTrip = TripRecyclerAdapter()
        rvNotifications.adapter = adapterTrip

    }
}