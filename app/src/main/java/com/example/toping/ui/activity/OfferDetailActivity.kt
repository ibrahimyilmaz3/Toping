package com.example.toping.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_offer_detail.*
import kotlinx.android.synthetic.main.custom_top.*

class OfferDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_detail)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvHeading.text = "Kampanya Detayları"
        cardBack.setOnClickListener { finish() }
        btnJoin.setOnClickListener {
            Toast.makeText(this, "Başarıyla katıldınız!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}