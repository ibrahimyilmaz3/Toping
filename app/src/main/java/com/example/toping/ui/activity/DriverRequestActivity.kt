package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.adapter.DriverRequestRecyclerAdapter
import com.example.toping.service.MenuHandlerDriver
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_driver_home.*
import kotlinx.android.synthetic.main.activity_driver_home.navigationView
import kotlinx.android.synthetic.main.activity_driver_request.*
import kotlinx.android.synthetic.main.activity_driver_request.drawerLayoutDriver
import kotlinx.android.synthetic.main.custom_top.*

class DriverRequestActivity : AppCompatActivity() {

    private var layoutManagerTrip: RecyclerView.LayoutManager? = null
    private var adapterTrip: RecyclerView.Adapter<DriverRequestRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_request)
        Tools().whiteStatusBar(this, window)
        MenuHandlerDriver(this, navigationView, drawerLayoutDriver, "DriverRequestActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvHeading.text = "Gelen Talepler"
        cardBack.setOnClickListener {
            finish()
        }

        layoutManagerTrip = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rvRequestDriver.layoutManager = layoutManagerTrip

        adapterTrip = DriverRequestRecyclerAdapter()
        rvRequestDriver.adapter = adapterTrip

    }
}