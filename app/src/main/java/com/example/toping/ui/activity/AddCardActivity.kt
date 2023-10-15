package com.example.toping.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.toping.R
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.DateFragment
import com.example.toping.ui.dialog.Info2Fragment
import com.example.toping.ui.dialog.Info5Fragment
import com.example.toping.util.BaseAppCompatActivity
import com.example.toping.util.FourDigitCardFormatWatcher
import kotlinx.android.synthetic.main.activity_add_card.*
import kotlinx.android.synthetic.main.custom_top.*


class AddCardActivity : BaseAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        header()
        keyboard()
        check()
        click()
        span()

        etCard.addTextChangedListener(FourDigitCardFormatWatcher())

    }

    private fun span() {
        val spannable = SpannableString("Katılım koşullarını okudum ve onaylıyorum.")
        spannable.setSpan(
            UnderlineSpan(),
            0,
            19,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvPolicy.text = spannable
    }

    private fun click() {
        tvDate.setOnClickListener {
            val dateFragment = DateFragment()
            dateFragment.show(supportFragmentManager, "dateFragment")
            dateFragment.result.observe(this) {
                tvDate.text = it
            }
        }
        linearPolicy.setOnClickListener {
            val i = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.wookweb.com/gizlilik-sozlesmesi/")
            )
            startActivity(i)
        }
        btnAdd.setOnClickListener {
            val info5Fragment = Info5Fragment()
            info5Fragment.show(supportFragmentManager, "info5Fragment")
        }
    }

    private fun check() {
        checkPrimaryCard.setOnClickListener {
            when {
                checkPrimaryCard.isChecked -> checkPrimaryCard.buttonTintList =
                    ContextCompat.getColorStateList(this, R.color.blue)
                else -> checkPrimaryCard.buttonTintList =
                    ContextCompat.getColorStateList(this, R.color.gray)
            }
        }
        checkTerms.setOnClickListener {
            when {
                checkTerms.isChecked -> checkTerms.buttonTintList =
                    ContextCompat.getColorStateList(this, R.color.blue)
                else -> checkTerms.buttonTintList =
                    ContextCompat.getColorStateList(this, R.color.gray)
            }
        }
    }

    private fun keyboard() {
        mainLinearAddCard.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    private fun header() {
        tvHeading.text = "Kart Ekle"
        cardBack.setOnClickListener {
            finish()
        }
    }
}