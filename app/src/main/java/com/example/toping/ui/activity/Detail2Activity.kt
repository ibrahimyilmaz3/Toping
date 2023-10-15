package com.example.toping.ui.activity

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.Picture2Adapter
import com.example.toping.model.Tour
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_detail2.*

class Detail2Activity : AppCompatActivity() {

    private val tour = ArrayList<Tour>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)
        //tour
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        dataInitialize()

        cardBack.setOnClickListener { finish() }

        btnCancel.setOnClickListener {
            Toast.makeText(this, "Rezervasyon iptal edildi!", Toast.LENGTH_SHORT).show()
            finish()
        }

        rvPicture.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        rvPicture.adapter = Picture2Adapter(tour)



        val str1 = "Rezervasyon Saati: 16:30"
        val span1 = SpannableString(str1)
        span1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            18,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )

        val str2 = "Toplam Kilometre: 30 Kilometre"
        val span2 = SpannableString(str2)
        span2.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            17,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )

        val str3 = "Toplam Süre: 120 Dakika"
        val span3 = SpannableString(str3)
        span3.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            12,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )

        val str4 = "Rezervasyon Tarihi: 16/05/2023"
        val span4 = SpannableString(str4)
        span4.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            18,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )

        val str5 = "Ödeme Türü: Nakit"
        val span5 = SpannableString(str5)
        span5.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            0,
            11,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )


        tvName.text = tour[0].name
        tvPrice.text = tour[0].price
        tvDescription.text = tour[0].description
        tvDate.text = span4
        tvDuration.text = span3
        tvMileage.text = span2
        tvHour.text = span1
        tvPayment.text = span5

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