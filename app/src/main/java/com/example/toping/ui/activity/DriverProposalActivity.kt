package com.example.toping.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.Info4Fragment
import kotlinx.android.synthetic.main.activity_driver_propopal.*
import kotlinx.android.synthetic.main.activity_driver_propopal.btnSend
import kotlinx.android.synthetic.main.activity_driver_propopal.cardBackProposal
import kotlinx.android.synthetic.main.activity_driver_propopal.etPropose
import kotlinx.android.synthetic.main.activity_driver_propopal.mainLinear
import kotlinx.android.synthetic.main.activity_proposal.*

class DriverProposalActivity : AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_propopal)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        cardBackProposal.setOnClickListener {
            onBackPressed()
        }

        etPropose.requestFocus()
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)

        mainLinear.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        btnSend.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            val info4Fragment = Info4Fragment()
            info4Fragment.show(supportFragmentManager, "info4Fragment")
        }

    }
}