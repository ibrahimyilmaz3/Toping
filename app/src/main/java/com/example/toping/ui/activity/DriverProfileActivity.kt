package com.example.toping.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.toping.R
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.LanguageFragment
import com.example.toping.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_driver_profile.*

@Suppress("DEPRECATION")
class DriverProfileActivity : BaseAppCompatActivity() {

    private val pickImage = 100
    private val pickImage2 = 99
    private val pickImage3 = 98
    private val pickImage4 = 97
    private val pickImage5 = 96
    private var imageUri: Uri? = null
    private var imageUri2: Uri? = null
    private var imageUri3: Uri? = null
    private var imageUri4: Uri? = null
    private var imageUri5: Uri? = null

    private var backPressedOnce = false
    private var doubleBackPressedTime: Long = 0

    override fun onBackPressed() {
        if (backPressedOnce) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - doubleBackPressedTime < 2000) {
                super.onBackPressed()
            } else {
                backPressedOnce = false
            }
        } else {
            backPressedOnce = true
            doubleBackPressedTime = System.currentTimeMillis()
            Toast.makeText(this, "Çıkış yapmak için tekrar dokunun", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_profile)
        Tools().whiteStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        click()
        keyboard()
        gallery()
        format()
        dialog()

    }

    private fun click() {
        btnNext.setOnClickListener {
            val intent = Intent(this, AddVehicleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun keyboard() {
        mainLinear.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    private fun gallery() {
        relImage.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        cardLicense.setOnClickListener {
            val gallery2 = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery2, pickImage2)
        }

        cardRecord.setOnClickListener {
            val gallery3 = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery3, pickImage3)
        }

        cardSRC.setOnClickListener {
            val gallery4 = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery4, pickImage4)
        }

        cardTech.setOnClickListener {
            val gallery5 = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery5, pickImage5)
        }
    }

    private fun format() {
        etNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                etNumber.removeTextChangedListener(this)

                val formattedText = formatInput(s.toString())
                etNumber.setText(formattedText)
                etNumber.setSelection(formattedText.length)

                etNumber.addTextChangedListener(this)
            }
        })
    }

    private fun dialog() {
        linearNat.setOnClickListener {
            val countryFragment = LanguageFragment()
            countryFragment.show(supportFragmentManager, "countryFragment")
            countryFragment.result.observe(this) {
                val str = it.joinToString(", ")
                tvNat.text = str
                countryFragment.dismiss()
            }
        }
    }

    private fun formatInput(input: String): String {
        val cleanInput = input.replace(" ", "")
        val sb = StringBuilder()

        for ((index, char) in cleanInput.withIndex()) {
            if (index == 2) {
                sb.append(char)
                sb.append(" ")
            } else if (index == 6 || index == 10 || index == 14) {
                sb.append(" ")
                sb.append(char)
            } else {
                sb.append(char)
            }
        }

        return sb.toString()
    }

    //Image from Gallery
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            ivDriverProfile.setImageURI(imageUri)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage2) {
            imageUri2 = data?.data
            ivLicence.setImageURI(imageUri2)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage3) {
            imageUri3 = data?.data
            ivRecord.setImageURI(imageUri3)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage4) {
            imageUri4 = data?.data
            ivSRC.setImageURI(imageUri4)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage5) {
            imageUri5 = data?.data
            ivTech.setImageURI(imageUri5)
        }
    }

}