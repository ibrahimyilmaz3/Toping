package com.example.toping.service

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.toping.ui.activity.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.menu_drawer_end_driver.view.*

class MenuHandlerDriver(
    var context: Context,
    navigationView: NavigationView,
    drawerLayoutDriver: DrawerLayout,
    current: String
) {
    init {
        val view = navigationView.getHeaderView(0)

        view.linearTripsDriver.setOnClickListener {
            if (current != "DriverTripActivity") funIntent(DriverTripActivity())
            else {
                drawerLayoutDriver.closeDrawer(GravityCompat.END)
            }
        }
        view.linearRequest.setOnClickListener {
            if (current != "DriverRequestActivity") funIntent(DriverRequestActivity())
            else {
                drawerLayoutDriver.closeDrawer(GravityCompat.END)
            }
        }
        view.linearBalance.setOnClickListener {
            if (current != "DriverBalanceActivity") funIntent(DriverBalanceActivity())
            else {
                drawerLayoutDriver.closeDrawer(GravityCompat.END)
            }
        }
        view.linearHelpDriver.setOnClickListener {
            if (current != "DriverHelpActivity") funIntent(DriverHelpActivity())
            else {
                drawerLayoutDriver.closeDrawer(GravityCompat.END)
            }
        }
        view.linearSettingsDriver.setOnClickListener {
            if (current != "DriverSettingsActivity") funIntent(DriverSettingsActivity())
            else {
                drawerLayoutDriver.closeDrawer(GravityCompat.END)
            }
        }
        view.linearProfileDriver.setOnClickListener {
            funIntent(DriverProfileActivity())
        }
        view.ivCloseDrawerDriver.setOnClickListener {
            drawerLayoutDriver.closeDrawer(GravityCompat.END)
        }
    }

    private fun funIntent(activity: Activity) {
        val intent = Intent(context, activity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }
}

