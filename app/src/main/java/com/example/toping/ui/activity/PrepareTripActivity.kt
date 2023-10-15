package com.example.toping.ui.activity

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.CancelFragment
import kotlinx.android.synthetic.main.activity_prepare_trip.*

class PrepareTripActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prepare_trip)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        cardConfirmingTrip.visibility = View.VISIBLE
        linearTip.visibility = View.VISIBLE
        cardTripConfirmed.visibility = View.GONE

        imgTempTouch.setOnClickListener {
            cardTripConfirmed.visibility = View.VISIBLE
            linearTip.visibility = View.GONE
        }

        btnTripConfirmed.setOnClickListener {
            cardTripConfirmed.visibility = View.GONE
            cardConfirmingTrip.visibility = View.GONE
            cardDriverArriving.visibility = View.VISIBLE
        }

        imgTempTouch2.setOnClickListener {
            cardMeetingPoint.visibility = View.VISIBLE
            cardUpdateTrip.visibility = View.VISIBLE
        }

        tvCancelToDialog.setOnClickListener {
            val cancelFragment = CancelFragment()
            cancelFragment.show(supportFragmentManager, "cancelFragment")
        }

        btnCancelTrip.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}