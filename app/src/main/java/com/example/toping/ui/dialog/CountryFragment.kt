package com.example.toping.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.CountryAdapter
import com.example.toping.model.Country
import kotlinx.android.synthetic.main.dialog_nationality.view.*

class CountryFragment : DialogFragment() {

    private val country = ArrayList<Country>()
    private val adapter = CountryAdapter(country)
    val result = MutableLiveData<String>()

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.9).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val view = inflater.inflate(R.layout.dialog_nationality, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp
        dataInitialize()

        view.rvDialog.adapter = adapter
        view.rvDialog.layoutManager = LinearLayoutManager(requireContext())

        view.tvHeadingDialog.text = "Uyruğunuzu seçin"
        view.btnConfirm.setOnClickListener {
            result.value = adapter.result.value
        }

        return view
    }

    private fun dataInitialize() {
        country.add(Country("Türk"))
        country.add(Country("Fransız"))
        country.add(Country("Alman"))
        country.add(Country("Bolivyalı"))
        country.add(Country("Türk"))
        country.add(Country("Fransız"))
        country.add(Country("Alman"))
        country.add(Country("Bolivyalı"))
        country.add(Country("Türk"))
        country.add(Country("Fransız"))
        country.add(Country("Alman"))
        country.add(Country("Bolivyalı"))
        country.add(Country("Türk"))
        country.add(Country("Fransız"))
        country.add(Country("Alman"))
        country.add(Country("Bolivyalı"))
        country.add(Country("Türk"))
        country.add(Country("Fransız"))
        country.add(Country("Alman"))
        country.add(Country("Bolivyalı"))
        country.add(Country("Türk"))
        country.add(Country("Fransız"))
        country.add(Country("Alman"))
        country.add(Country("Bolivyalı"))
        country.add(Country("Türk"))
        country.add(Country("Fransız"))
        country.add(Country("Alman"))
        country.add(Country("Bolivyalı"))
    }

}