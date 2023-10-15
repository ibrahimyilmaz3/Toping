package com.example.toping.ui.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.service.MenuHandler
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.CountryFragment
import com.example.toping.ui.dialog.GenderFragment
import com.example.toping.ui.dialog.Info2Fragment
import com.example.toping.ui.dialog.InfoFragment
import com.example.toping.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.custom_top.*

@Suppress("DEPRECATION")
class ProfileActivity : BaseAppCompatActivity() {

    private val pickImage = 100
    private var imageUri: Uri? = null

    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Tools().whiteStatusBar(this, window)
        MenuHandler(this, navigationView, drawerLayout, "ProfileActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //Image from Gallery
        relativeChangePrPic.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        tvHeading.text = "Profilim"
        cardBack.setOnClickListener {
            finish()
        }

/*      setMale.setOnClickListener {
            setMale.setBackgroundResource(R.drawable.round_20_medium_blue)
            setFemale.setBackgroundResource(R.drawable.round_20_white)
        }

        setFemale.setBackgroundResource(R.drawable.round_20_medium_blue)
        setFemale.setOnClickListener {
            setMale.setBackgroundResource(R.drawable.round_20_white)
            setFemale.setBackgroundResource(R.drawable.round_20_medium_blue)
        }*/

        linearNat.setOnClickListener {
            val countryFragment = CountryFragment()
            countryFragment.show(supportFragmentManager, "countryFragment")
            countryFragment.result.observe(this) {
                tvNat.text = it
                countryFragment.dismiss()
            }
        }
        linearGender.setOnClickListener {
            val genderFragment = GenderFragment()
            genderFragment.show(supportFragmentManager, "genderFragment")
            genderFragment.result.observe(this) {
                tvGender.text = it
                genderFragment.dismiss()
            }
        }

        mainLinear.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        btnSave.setOnClickListener {
            val info2Fragment = Info2Fragment()
            info2Fragment.show(supportFragmentManager, "info2Fragment")
        }
    }

    //Image from Gallery
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imgProfilePic.setImageURI(imageUri)
        }
    }
}