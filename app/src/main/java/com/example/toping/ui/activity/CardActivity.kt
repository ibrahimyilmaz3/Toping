package com.example.toping.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.CardAdapter
import com.example.toping.model.CardNumber
import com.example.toping.service.MenuHandler
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_card.*
import kotlinx.android.synthetic.main.activity_home.drawerLayout
import kotlinx.android.synthetic.main.activity_home.navigationView
import kotlinx.android.synthetic.main.custom_top.*

class CardActivity : AppCompatActivity() {

    private var number = ArrayList<CardNumber>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        Tools().whiteStatusBar(this, window)
        MenuHandler(this, navigationView, drawerLayout, "CardActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        dataInitialize()

        tvHeading.text = "Kredi Kartlarım"
        cardBack.setOnClickListener {
            finish()
        }

        rvCards.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rvCards.adapter = CardAdapter(number)

        btnAddCard.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            startActivity(intent)
        }
    }

    /*private fun goTransaction(fragment: Fragment) {
        if (supportFragmentManager.findFragmentById(android.R.id.content) == null) {
            supportFragmentManager.beginTransaction().add(android.R.id.content, fragment).commit();
        }
        drawerLayout.visibility = View.INVISIBLE
    }*/

    private fun dataInitialize() {
        number.add(CardNumber("2143 2423 5345 4323 6789"))
        number.add(CardNumber("2143 2423 5345 4323 6789"))
        number.add(CardNumber("2143 2423 5345 4323 6789"))
        number.add(CardNumber("2143 2423 5345 4323 6789"))
        number.add(CardNumber("2143 2423 5345 4323 6789"))
    }

}