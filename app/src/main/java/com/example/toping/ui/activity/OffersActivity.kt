package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.adapter.OffersRecyclerAdapter
import com.example.toping.service.MenuHandler
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_home.drawerLayout
import kotlinx.android.synthetic.main.activity_home.navigationView
import kotlinx.android.synthetic.main.activity_offers.*
import kotlinx.android.synthetic.main.custom_top.*

class OffersActivity : AppCompatActivity() {

    private var layoutManagerOffers: RecyclerView.LayoutManager? = null
    private var adapterOffers: RecyclerView.Adapter<OffersRecyclerAdapter.ViewHolder>? = null

    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offers)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        MenuHandler(this, navigationView, drawerLayout, "OffersActivity")

        tvHeading.text = "Kampanyalar"
        cardBack.setOnClickListener {
            finish()
        }

        layoutManagerOffers = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rvOffers.layoutManager = layoutManagerOffers

        adapterOffers = OffersRecyclerAdapter()
        rvOffers.adapter = adapterOffers

    }
}