package com.example.toping.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.toping.R
import com.example.toping.model.Request
import com.example.toping.model.Trip
import com.example.toping.service.Tools
import com.example.toping.util.funIntent
import kotlinx.android.synthetic.main.activity_detail4.*
import kotlinx.android.synthetic.main.custom_top.*
import java.util.ArrayList

class Detail4Activity : AppCompatActivity() {

    private var list1 = ArrayList<Request>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail4)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        cardBack.setOnClickListener { finish() }
        tvHeading.text = "Talep Detay"

        btnDetail.setOnClickListener { funIntent(Detail5Activity()) }

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

        val str10 = "Başlangıç Noktası: ${list1[0].trip!!.start}"
        val span10 = SpannableString(str10)
        span10.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)),
            0,
            18,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        tvStart.text = span10

        val str9 = "Durak Noktası 1: ${list1[0].trip!!.stop1}"
        val span9 = SpannableString(str9)
        span9.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)),
            0,
            16,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        tvStop1.text = span9

        val str8 = "Durak Noktası 2: ${list1[0].trip!!.stop2}"
        val span8 = SpannableString(str8)
        span8.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)),
            0,
            16,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        tvStop2.text = span8

        val str7 = "Varış Noktası: ${list1[0].trip!!.destination}"
        val span7 = SpannableString(str7)
        span7.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)),
            0,
            14,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        tvDestination.text = span7

        val str2 = "Rezervasyon Tarihi: ${list1[0].trip!!.date}"
        val span2 = SpannableString(str2)
        span2.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            19,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        tvDate.text = span2

        val str4 = "Rezervasyon Saati: ${list1[0].trip!!.hour}"
        val span4 = SpannableString(str4)
        span4.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            18,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        tvHour.text = span4

        val str6 = "Ödeme Türü: ${list1[0].trip!!.payment}"
        val span6 = SpannableString(str6)
        span6.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            11,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        tvPayment.text = span6

    }
}