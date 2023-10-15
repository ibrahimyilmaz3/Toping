package com.example.toping.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.toping.R
import com.example.toping.service.MenuHandlerDriver
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.DeleteFragment
import com.example.toping.ui.dialog.Info3Fragment
import com.example.toping.util.funClearIntent
import com.mohammedalaa.seekbar.OnRangeSeekBarChangeListener
import com.mohammedalaa.seekbar.RangeSeekBarView
import kotlinx.android.synthetic.main.activity_driver_settings.*
import kotlinx.android.synthetic.main.custom_top.*

class DriverSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_settings)
        Tools().whiteStatusBar(this, window)
        MenuHandlerDriver(this, navigationView, drawerLayoutDriver, "DriverSettingsActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        top()
        seek()


        btnExit.setOnClickListener {
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

    private fun seek() {
        tvSeekDistance.text = rangeSeekbar.currentValue.toString()
        rangeSeekbar.setOnRangeSeekBarViewChangeListener(object : OnRangeSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: RangeSeekBarView?,
                progress: Int,
                fromUser: Boolean
            ) {
                tvSeekDistance.text = rangeSeekbar.currentValue.toString()
            }

            override fun onStartTrackingTouch(seekBar: RangeSeekBarView?, progress: Int) {
            }

            override fun onStopTrackingTouch(seekBar: RangeSeekBarView?, progress: Int) {
            }
        })
    }

    private fun top() {
        tvHeading.text = "Ayarlar"
        cardBack.setOnClickListener {
            finish()
        }
    }

    private fun transaction(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        //transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}