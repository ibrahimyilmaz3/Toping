package com.example.toping.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_driver_request_detail.*

class DriverRequestDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_request_detail)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        Tools().whiteStatusBar(this, window)

        cardBack.setOnClickListener {
            finish()
        }

    }
}