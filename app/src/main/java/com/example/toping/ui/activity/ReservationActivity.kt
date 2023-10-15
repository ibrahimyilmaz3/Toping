package com.example.toping.ui.activity

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.`object`.Main.paymentMethod
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.ReserveFragment
import kotlinx.android.synthetic.main.activity_reservation.*

class ReservationActivity : AppCompatActivity() {

    private var extended = 1

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)
        supportActionBar?.hide()
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        paymentMethod = 1

        cardBackToMain.setOnClickListener {
            finish()
        }

        btnContinue.setOnClickListener {
            val reserveFragment = ReserveFragment()
            reserveFragment.show(supportFragmentManager, "reserveFragment")
        }

        imgExtend.setImageResource(R.drawable.arrow_down)
        linearPaymentMethod.visibility = View.GONE

        linearUpperMethod.setOnClickListener {
            if (extended == 0) {
                imgExtend.setImageResource(R.drawable.arrow_down)
                linearPaymentMethod.visibility = View.GONE
                extended = 1
            } else {
                imgExtend.setImageResource(R.drawable.arrow_up)
                linearPaymentMethod.visibility = View.VISIBLE
                extended = 0
            }
        }
        linearCardMethod.setBackgroundResource(R.drawable.linear_bottom_border_blue)
        linearCardMethod.setOnClickListener {
            linearCardMethod.setBackgroundResource(R.drawable.linear_bottom_border_blue)
            linearPayPalMethod.setBackgroundResource(R.drawable.linear_bottom_border_none)
            linearCashMethod.setBackgroundResource(R.drawable.linear_bottom_border_none)
            tvUpdateMethod.text = getString(R.string.credit_card)
            paymentMethod = 1
        }
        linearCashMethod.setOnClickListener {
            linearCardMethod.setBackgroundResource(R.drawable.linear_bottom_border_none)
            linearPayPalMethod.setBackgroundResource(R.drawable.linear_bottom_border_none)
            linearCashMethod.setBackgroundResource(R.drawable.linear_bottom_border_blue)
            tvUpdateMethod.text = getString(R.string.cash)
            paymentMethod = 2
        }
        linearPayPalMethod.setOnClickListener {
            linearCardMethod.setBackgroundResource(R.drawable.linear_bottom_border_none)
            linearPayPalMethod.setBackgroundResource(R.drawable.linear_bottom_border_blue)
            linearCashMethod.setBackgroundResource(R.drawable.linear_bottom_border_none)
            tvUpdateMethod.text = getString(R.string.pay_pal)
            paymentMethod = 2
        }

        linearXL.setBackgroundResource(R.drawable.round_10_blue_corner_solid_white)
        linearEco.setBackgroundResource(R.drawable.round_10_shadow_1dp)
        linearXL.setOnClickListener {
            linearXL.setBackgroundResource(R.drawable.round_10_blue_corner_solid_white)
            linearEco.setBackgroundResource(R.drawable.round_10_shadow_1dp)
        }

        linearEco.setOnClickListener {
            linearXL.setBackgroundResource(R.drawable.round_10_shadow_1dp)
            linearEco.setBackgroundResource(R.drawable.round_10_blue_corner_solid_white)
        }
    }

}