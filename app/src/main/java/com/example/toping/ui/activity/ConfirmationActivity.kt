package com.example.toping.ui.activity

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.`object`.Phone
import com.example.toping.util.BaseAppCompatActivity
import com.example.toping.util.MainObject
import com.example.toping.util.funIntent
import kotlinx.android.synthetic.main.activity_confirmation.*

class ConfirmationActivity : BaseAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        transparentStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btnContinueMain.setOnClickListener {
            if (MainObject.navigate == 0) {
                funIntent(HomeActivity())
            } else {
                funIntent(NameActivity())
            }
        }

        val str1 = "Onay kodunuz "
        val str2 = "+90 " + Phone.number
        val str3 = "numaralı telefonunuza gönderildi."
        val span1 = SpannableString(str1)
        val span2 = SpannableString(str2)
        val span3 = SpannableString(str3)

        val builder = SpannableStringBuilder()
        builder.append(span1).append(" ").append(span2).append(" ").append(span3)

        tvNumber.text = builder

    }

    fun transparentStatusBar(context: Context, window: Window) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}