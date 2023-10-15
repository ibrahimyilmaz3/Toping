package com.example.toping.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.`object`.Route.navRoute
import com.example.toping.`object`.Route.route
import com.example.toping.adapter.RouteAdapter
import com.example.toping.model.Route
import com.example.toping.service.Tools
import com.example.toping.util.funIntent
import kotlinx.android.synthetic.main.activity_transfer.*

class TransferActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        rvRoute.adapter!!.notifyDataSetChanged()
        scrollView.post {
            scrollView.fullScroll(View.FOCUS_DOWN)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        route.clear()
        route.add(Route("Başlangıç Noktası",null))
        route.add(Route("Varış Noktası",null))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)
        //supportActionBar?.hide()
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        cardBack.setOnClickListener { finish() }

        btnContinue.setOnClickListener { funIntent(ReservationActivity()) }

        rvRoute.layoutManager = LinearLayoutManager(this)
        val routeAdapter = RouteAdapter(route)
        rvRoute.adapter = routeAdapter

        btnAdd.setOnClickListener {
            navRoute = 2
            funIntent(ChooseActivity())
        }

    }
}