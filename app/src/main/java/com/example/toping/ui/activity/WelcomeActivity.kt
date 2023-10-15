package com.example.toping.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.util.MainObject
import com.example.toping.util.funIntent
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private var backPressedOnce = false
    private var doubleBackPressedTime: Long = 0

    override fun onBackPressed() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        transparentStatusBar(this, window)
        supportActionBar?.hide()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btnRent.setOnClickListener {
            val intent = Intent(this, PhoneNumberActivity::class.java)
            startActivity(intent)
        }

        tvLogInAsDriver.setOnClickListener {
            val intent = Intent(this, DriverWelcomeActivity::class.java)
            startActivity(intent)
        }

        tvSignUp.setOnClickListener {
            MainObject.navigate = 1
            funIntent(PhoneNumberActivity())
        }

    }


    fun transparentStatusBar(context: Context, window: Window) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}