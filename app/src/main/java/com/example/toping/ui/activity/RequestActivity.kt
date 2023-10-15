package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.RequestAdapter
import com.example.toping.model.Request
import com.example.toping.model.Tour2
import com.example.toping.model.Trip
import com.example.toping.service.MenuHandler
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_home.drawerLayout
import kotlinx.android.synthetic.main.activity_home.navigationView
import kotlinx.android.synthetic.main.activity_request.*
import kotlinx.android.synthetic.main.custom_top.*
import java.util.*

class RequestActivity : AppCompatActivity() {

    private var list1 = ArrayList<Request>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)
        Tools().whiteStatusBar(this, window)
        MenuHandler(this, navigationView, drawerLayout, "RequestActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        cardBack.setOnClickListener { finish() }
        tvHeading.text = "Rezervasyon Taleplerim"

        dataInitialize()

        rvRequest.adapter = RequestAdapter(list1)
        rvRequest.layoutManager = LinearLayoutManager(this)
    }

    private fun dataInitialize() {
        list1.add(
            Request(
                "Tur",
                Tour2(
                    "500.90₺",
                    "Tarihi Yerler Turu",
                    "Trabzon Kalesi, Trabzon'un en yüksek kesimindeki kale, Trabzon’da günümüze en iyi durumda ulaşabilen eserlerin başında gelmektedir. ",
                    "16/02/2023",
                    "16:00",
                    "Nakit"
                ), null
            )
        )
        list1.add(
            Request(
                "Transfer",
                null, Trip(
                    "600.90₺",
                    "Sümela Manastırı",
                    "Ayasofya Müzesi",
                    "Doğa Parkı",
                    "Forum Trabzon",
                    "19/04/2023",
                    "18:00",
                    "Kredi Kartı"
                )
            )
        )
    }
}