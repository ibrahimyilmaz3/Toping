package com.example.toping.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.`object`.Main.cardSelected
import com.example.toping.adapter.Card2Adapter
import com.example.toping.model.CardNumber
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.Info7Fragment
import kotlinx.android.synthetic.main.activity_card2.*
import kotlinx.android.synthetic.main.activity_offer_detail.*
import kotlinx.android.synthetic.main.custom_top.*

class Card2Activity : AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()
        cardSelected = 0
    }

    private var number = ArrayList<CardNumber>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card2)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        dataInitialize()

        tvHeading.text = "Kart Seçimi"
        cardBack.setOnClickListener {
            finish()
        }

        rvCards.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rvCards.adapter = Card2Adapter(number)

        btnContinue.setOnClickListener {
            if (cardSelected == 1) {
                val info7Fragment = Info7Fragment()
                info7Fragment.show(supportFragmentManager, "info7Fragment")
            } else {
                Toast.makeText(this, "Lütfen kart seçiniz!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun dataInitialize() {
        number.add(CardNumber("2143 2423 5345 4323 6789"))
        number.add(CardNumber("2143 2423 5345 4323 6789"))
        number.add(CardNumber("2143 2423 5345 4323 6789"))
        number.add(CardNumber("2143 2423 5345 4323 6789"))
        number.add(CardNumber("2143 2423 5345 4323 6789"))
    }
}