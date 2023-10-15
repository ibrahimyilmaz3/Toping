package com.example.toping.service

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.toping.ui.activity.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.menu_drawer_end.view.*

class MenuHandler(
    var context: Context,
    navigationView: NavigationView,
    drawerLayout: DrawerLayout,
    current: String
) {
    init {
        val view = navigationView.getHeaderView(0)

        view.linearTrips.setOnClickListener {
            if (current != "TripActivity") funIntent(TripActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }

        view.linearWallet.setOnClickListener {
            if (current != "WalletActivity") funIntent(WalletActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }



        view.linearRequest.setOnClickListener {
            if (current != "RequestActivity") funIntent(RequestActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }
        view.linearActive.setOnClickListener {
            if (current != "ActiveActivity") funIntent(ActiveActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }



        view.linearOffer.setOnClickListener {
            if (current != "OffersActivity") funIntent(OffersActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }

        view.linearCard.setOnClickListener {
            if (current != "CardActivity") funIntent(CardActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }

        view.linearNotification.setOnClickListener {
            if (current != "NotificationsActivity") funIntent(NotificationsActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }

        view.linearSettings.setOnClickListener {
            if (current != "SettingsActivity") funIntent(SettingsActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }

        view.linearHelp.setOnClickListener {
            if (current != "HelpActivity") funIntent(HelpActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }
        view.linearProfile.setOnClickListener {
            if (current != "ProfileActivity") funIntent(ProfileActivity())
            else {
                drawerLayout.closeDrawer(GravityCompat.END)
            }
        }
        view.ivCloseDrawer.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.END)
        }
    }

    private fun funIntent(activity: Activity) {
        val intent = Intent(context, activity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }
}

