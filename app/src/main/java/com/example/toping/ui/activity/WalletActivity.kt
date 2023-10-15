package com.example.toping.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.adapter.WalletRecyclerAdapter
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.Info4Fragment
import com.example.toping.ui.dialog.Info6Fragment
import com.example.toping.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_wallet.*
import kotlinx.android.synthetic.main.custom_top.*

class WalletActivity : BaseAppCompatActivity() {

    override fun onBackPressed() {
        finish()
    }

    private var list = ArrayList<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        Tools().whiteStatusBar(this, window)
        //supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvHeading.text = "Toping Cüzdanım"
        cardBack.setOnClickListener {
            finish()
        }

        btnBuy.setOnClickListener {
            val info6Fragment = Info6Fragment()
            info6Fragment.show(supportFragmentManager, "info6Fragment")
        }

        linear.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        price()
        toastMe()
}
    private fun price() {
        list.add(tvPrice1)
        list.add(tvPrice2)
        list.add(tvPrice3)
        list.add(tvPrice4)
        list.add(tvPrice5)
        list.add(tvPrice6)
    }

    private fun toastMe() {
        for (i in list) {
            i.setOnClickListener {
                for (btn in list) {
                    btn.background = ContextCompat.getDrawable(this, R.drawable.round_10_white)
                }
                i.background = ContextCompat.getDrawable(this, R.drawable.round_10_blue_corner_solid_white)
            }
        }

    }


}