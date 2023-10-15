package com.example.toping.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.toping.R
import com.example.toping.service.Tools
import com.example.toping.ui.dialog.BrandFragment
import com.example.toping.ui.dialog.ModelFragment
import com.example.toping.ui.dialog.YearFragment
import com.example.toping.util.BaseAppCompatActivity
import com.example.toping.util.PlateValidator
import com.example.toping.util.funClearIntent
import kotlinx.android.synthetic.main.activity_add_vehicle.*

class AddVehicleActivity : BaseAppCompatActivity() {

    private val pickImage = 100
    private val pickImage2 = 99
    private val pickImage3 = 98
    private val pickImage4 = 97
    private val pickImage5 = 96
    private val pickImage6 = 95
    private val pickImage7 = 94
    private val pickImage8 = 93
    private var imageUri: Uri? = null
    private var imageUri2: Uri? = null
    private var imageUri3: Uri? = null
    private var imageUri4: Uri? = null
    private var imageUri5: Uri? = null
    private var imageUri6: Uri? = null
    private var imageUri7: Uri? = null
    private var imageUri8: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vehicle)
        Tools().whiteStatusBar(this, window)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        click()
        keyboard()
        chooseSeat()

    }

    private fun click() {
        btnAddVehicle.setOnClickListener {
            if (PlateValidator().isPlateValid(etPlate.text.toString())) {
                funClearIntent(DriverHomeActivity())
            } else {
                Toast.makeText(this, "Lütfen geçerli bir plaka girin", Toast.LENGTH_SHORT).show()
            }
        }

        linearBrand.setOnClickListener {
            val brandFragment = BrandFragment()
            brandFragment.show(supportFragmentManager, "brandFragment")
            brandFragment.result.observe(this) {
                tvBrand.text = it
                brandFragment.dismiss()
            }
        }
        linearModel.setOnClickListener {
            val modelFragment = ModelFragment()
            modelFragment.show(supportFragmentManager, "modelFragment")
            modelFragment.result.observe(this) {
                tvModel.text = it
                modelFragment.dismiss()
            }
        }
        linearYear.setOnClickListener {
            val yearFragment = YearFragment()
            yearFragment.show(supportFragmentManager, "yearFragment")
            yearFragment.result.observe(this) {
                tvYear.text = it
                yearFragment.dismiss()
            }
        }

        cardFront.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
        cardBack.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage2)
        }
        cardLeft.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage3)
        }
        cardRight.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage4)
        }
        cardInside.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage5)
        }
        cardRegistration.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage6)
        }
        cardPolicy.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage7)
        }
        cardB2.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage8)
        }

    }

    private fun keyboard() {
        mainLinearAdd.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    private fun chooseSeat() {
        tvOneNine.setTextColor(ContextCompat.getColor(this, R.color.blue))
        tvOneNineteen.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
        tvOneThirtyOne.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
        tvFortySixPlus.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))

        cardOneNine.setOnClickListener {
            tvOneNine.setTextColor(ContextCompat.getColor(this, R.color.blue))
            tvOneNineteen.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
            tvOneThirtyOne.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
            tvFortySixPlus.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
        }

        cardOneNineTeen.setOnClickListener {
            tvOneNine.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
            tvOneNineteen.setTextColor(ContextCompat.getColor(this, R.color.blue))
            tvOneThirtyOne.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
            tvFortySixPlus.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
        }
        cardOneThirtyOne.setOnClickListener {
            tvOneNine.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
            tvOneNineteen.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
            tvOneThirtyOne.setTextColor(ContextCompat.getColor(this, R.color.blue))
            tvFortySixPlus.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
        }
        cardFortySixPLus.setOnClickListener {
            tvOneNine.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
            tvOneNineteen.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
            tvOneThirtyOne.setTextColor(ContextCompat.getColor(this, R.color.very_light_gray))
            tvFortySixPlus.setTextColor(ContextCompat.getColor(this, R.color.blue))
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            ivFront.setImageURI(imageUri)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage2) {
            imageUri2 = data?.data
            ivBack.setImageURI(imageUri2)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage3) {
            imageUri3 = data?.data
            ivLeft.setImageURI(imageUri3)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage4) {
            imageUri4 = data?.data
            ivRight.setImageURI(imageUri4)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage5) {
            imageUri5 = data?.data
            ivInside.setImageURI(imageUri5)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage6) {
            imageUri6 = data?.data
            ivRegistration.setImageURI(imageUri6)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage7) {
            imageUri7 = data?.data
            ivPolicy.setImageURI(imageUri7)
        }
        if (resultCode == RESULT_OK && requestCode == pickImage8) {
            imageUri8 = data?.data
            ivB2.setImageURI(imageUri8)
        }
    }

}