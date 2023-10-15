package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.adapter.NotificationsRecyclerAdapter
import com.example.toping.service.MenuHandler
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_home.drawerLayout
import kotlinx.android.synthetic.main.activity_home.navigationView
import kotlinx.android.synthetic.main.activity_trip.*
import kotlinx.android.synthetic.main.custom_top.*

class NotificationsActivity : AppCompatActivity() {

    private var layoutManagerNotifications: RecyclerView.LayoutManager? = null
    private var adapterNotifications: RecyclerView.Adapter<NotificationsRecyclerAdapter.ViewHolder>? =
        null

    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        Tools().whiteStatusBar(this, window)
        MenuHandler(this, navigationView, drawerLayout, "NotificationsActivity")
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

        rvNotifications.layoutManager = layoutManagerNotifications

        adapterNotifications = NotificationsRecyclerAdapter()
        rvNotifications.adapter = adapterNotifications

    }
}