package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.TourAdapter
import com.example.toping.model.Tour
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_tour.*

class TourActivity : AppCompatActivity() {

    private val tour = ArrayList<Tour>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tour)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        dataInitialize()
        cardBack.setOnClickListener { finish() }

        rvTour.layoutManager = LinearLayoutManager(this)
        val tourAdapter = TourAdapter(tour)
        rvTour.adapter = tourAdapter

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