package com.example.toping.service

import android.content.Context
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.toping.R

class Tools {

    /*fun greenStatusBar(context: Context, window: Window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, R.color.green)
        window.decorView.systemUiVisibility = 0
    }*/

    fun whiteStatusBar(context: Context, window: Window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    fun blueStatusBar(context: Context, window: Window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, R.color.blue)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    /*fun openBrowser(activity: Activity, url:String){
        val uri = Uri.parse(url)
        val intentBuilder = CustomTabsIntent.Builder()
        intentBuilder.setToolbarColor(ContextCompat.getColor(activity, R.color.green))
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(activity, R.color.white))
        val customTabsIntent = intentBuilder.build()
        customTabsIntent.launchUrl(activity, uri)
    }*/
}