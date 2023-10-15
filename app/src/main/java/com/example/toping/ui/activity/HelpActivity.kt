package com.example.toping.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.toping.R
import com.example.toping.service.MenuHandler
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_help.*
import kotlinx.android.synthetic.main.custom_top.*

class HelpActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        Tools().whiteStatusBar(this, window)
        MenuHandler(this, navigationView, drawerLayout, "HelpActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvHeading.text = "Yardım"
        cardBack.setOnClickListener {
            finish()
        }

        cardFAQ.setOnClickListener {
            val intent1 = Intent(this, FAQActivity::class.java)
            startActivity(intent1)
        }

        cardAbout.setOnClickListener {
            val intent2 = Intent(this, AboutActivity::class.java)
            startActivity(intent2)
        }

        cardProposal.setOnClickListener {
            val intent3 = Intent(this, ProposalActivity::class.java)
            startActivity(intent3)
        }

        cardTerms.setOnClickListener {
            val intent4 = Intent(this, TermsActivity::class.java)
            startActivity(intent4)
        }

    }

    private fun goTransaction(fragment: Fragment) {
        if (supportFragmentManager.findFragmentById(android.R.id.content) == null) {
            supportFragmentManager.beginTransaction().add(android.R.id.content, fragment).commit();
        }
        drawerLayout.visibility = View.INVISIBLE
    }

    private fun transaction(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        //transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}