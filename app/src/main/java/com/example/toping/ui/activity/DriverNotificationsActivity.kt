package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.adapter.DriverNotificationsRecyclerAdapter
import com.example.toping.service.MenuHandlerDriver
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_driver_notifications.*
import kotlinx.android.synthetic.main.activity_home.navigationView
import kotlinx.android.synthetic.main.custom_top.*

class DriverNotificationsActivity : AppCompatActivity() {

    private var layoutManagerNotifications: RecyclerView.LayoutManager? = null
    private var adapterNotifications: RecyclerView.Adapter<DriverNotificationsRecyclerAdapter.ViewHolder>? =
        null

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_notifications)
        Tools().whiteStatusBar(this, window)
        MenuHandlerDriver(this, navigationView, drawerLayoutDriver, "DriverNotificationsActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvHeading.text = "Bildirimler"
        cardBack.setOnClickListener {
            finish()
        }

        layoutManagerNotifications = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rvDriverNotifications.layoutManager = layoutManagerNotifications

        adapterNotifications = DriverNotificationsRecyclerAdapter()
        rvDriverNotifications.adapter = adapterNotifications

    }
}