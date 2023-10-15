package com.example.toping.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_splash.*
import kotlin.concurrent.fixedRateTimer

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        Tools().blueStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        fixedRateTimer("splash", false, 1000, 1000) {
            runOnUiThread {
                val mainIntent = Intent(this@SplashActivity, WelcomeActivity::class.java)
                startActivity(mainIntent)
                finish()
                this.cancel()
            }
        }

        prLoad.rotation = -180f
    }
}