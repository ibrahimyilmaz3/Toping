package com.example.toping.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.toping.R
import com.example.toping.service.MenuHandlerDriver
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_driver_help.*
import kotlinx.android.synthetic.main.activity_driver_help.drawerLayoutDriver
import kotlinx.android.synthetic.main.activity_driver_help.navigationView
import kotlinx.android.synthetic.main.activity_driver_home.*
import kotlinx.android.synthetic.main.custom_top.*

class DriverHelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_help)
        Tools().whiteStatusBar(this, window)
        MenuHandlerDriver(this, navigationView, drawerLayoutDriver, "DriverHelpActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvHeading.text = "Yardım"
        cardBack.setOnClickListener {
            finish()
        }

        cardFAQ.setOnClickListener {
            val intent1 = Intent(this, DriverFAQActivity::class.java)
            startActivity(intent1)
        }
        cardAbout.setOnClickListener {
            val intent2 = Intent(this, DriverAboutActivity::class.java)
            startActivity(intent2)
        }
        cardProposal.setOnClickListener {
            val intent3 = Intent(this, DriverProposalActivity::class.java)
            startActivity(intent3)
        }
        cardTerms.setOnClickListener {
            val intent4 = Intent(this, DriverTermsActivity::class.java)
            startActivity(intent4)
        }


    }

    private fun goTransaction(fragment: Fragment) {
        if (supportFragmentManager.findFragmentById(android.R.id.content) == null) {
            supportFragmentManager.beginTransaction().add(android.R.id.content, fragment).commit()
        }
        drawerLayoutDriver.visibility = View.INVISIBLE
    }

    private fun transaction(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        //transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}