package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.toping.R
import com.example.toping.service.MenuHandler
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.DeleteFragment
import com.example.toping.ui.dialog.Info3Fragment
import com.example.toping.util.funClearIntent
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.custom_top.*

class SettingsActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        Tools().whiteStatusBar(this, window)
        MenuHandler(this, navigationView, drawerLayout, "SettingsActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        tvHeading.text = "Ayarlar"
        cardBack.setOnClickListener {
            finish()
        }

        btnExitApp.setOnClickListener {
            funClearIntent(WelcomeActivity())
        }

        btnDelete.setOnClickListener {
            val deleteFragment = DeleteFragment()
            deleteFragment.show(supportFragmentManager, "deleteFragment")
        }

        btnUpdate.setOnClickListener {
            val info3Fragment = Info3Fragment()
            info3Fragment.show(supportFragmentManager, "info3Fragment")
        }

    }

    private fun transaction(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        //transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}