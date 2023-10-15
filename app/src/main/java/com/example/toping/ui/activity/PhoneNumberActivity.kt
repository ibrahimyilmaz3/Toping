package com.example.toping.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.`object`.Phone
import com.example.toping.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_phone_number.*


class PhoneNumberActivity : BaseAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_phone_number)
        //transparentStatusBar(this, window)

        btnContinueNumber.setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java)
            startActivity(intent)
            Phone.number = etPhone.text.toString()
        }

        transparentStatusBar(this, window)

        //
        //EdittextPhone
        etPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher("TR"))
        /*
        etPhone.setText("+90")
        Selection.setSelection(etPhone.text, etPhone.text.length)

        etPhone.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!s.toString().startsWith("+90")) {
                    etPhone.setText("+90")
                    Selection.setSelection(etPhone.text, etPhone.text.length)
                }
            }
        })*/
        //EdittextPhone
        //
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