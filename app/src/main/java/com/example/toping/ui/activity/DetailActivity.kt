package com.example.toping.ui.activity

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.PictureAdapter
import com.example.toping.model.Tour
import com.example.toping.service.Tools
import com.example.toping.util.funIntent
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private val tour = ArrayList<Tour>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        dataInitialize()

        cardBack.setOnClickListener { finish() }
        btnReserve.setOnClickListener { funIntent(ReservationActivity()) }


        val str3 = "Toplam Kilometre: 50 Kilometre"
        val str4 = "Toplam Kilometre: 30 Kilometre"
        val span3 = SpannableString(str3)
        span3.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            17,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val span4 = SpannableString(str4)
        span4.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            17,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )



        val str5 = "Toplam Süre: 120 Dakika"
        val str6 = "Toplam Süre: 150 Dakika"
        val span5 = SpannableString(str5)
        span5.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            12,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val span6 = SpannableString(str6)
        span6.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            12,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )

        val intent = intent
        when (intent.getStringExtra("name")) {
            null -> throw IllegalArgumentException("Detail Act.")
            "Tarihi Yerler Turu" -> {
                tvName.text = tour[0].name
                tvPrice.text = tour[0].price
                tvDescription.text = tour[0].description
                tvDuration.text = span5
                tvMileage.text = span4
            }
            "Şehir Turu" -> {
                tvName.text = tour[1].name
                tvPrice.text = tour[1].price
                tvDescription.text = tour[1].description
                tvDuration.text = span6
                tvMileage.text = span3
            }
        }

        rvPicture.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        rvPicture.adapter = PictureAdapter(tour)

    }

    private fun dataInitialize() {
        tour.add(
            Tour(
                "Tarihi Yerler Turu",
                "590.90₺",
                "Deniz kıyısından başlayarak şehrin arkasındaki tepelere kadar uzanan Trabzon kalesi, Bizans Çağı’na ait eski temeller üzerinde yükselmiştir.",
                R.drawable.sumela1,
                R.drawable.sumela2,
                R.drawable.camburnu1
            )
        )
        tour.add(
            Tour(
                "Şehir Turu",
                "890.90₺",
                "Tarihiyle, kültürüyle ve estetiğiyle Trabzon'un inceliklerini, panoramik bir tur ile deneyimleme imkanı sunulmuştur.",
                R.drawable.mall1,
                R.drawable.mall2,
                R.drawable.museum1
            )
        )
        tour.add(
            Tour(
                "Tarihi Yerler Turu",
                "590.90₺",
                "Deniz kıyısından başlayarak şehrin arkasındaki tepelere kadar uzanan Trabzon kalesi, Bizans Çağı’na ait eski temeller üzerinde yükselmiştir.",
                R.drawable.sumela1,
                R.drawable.sumela2,
                R.drawable.camburnu1
            )
        )
    }

}