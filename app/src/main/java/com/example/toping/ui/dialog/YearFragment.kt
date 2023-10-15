package com.example.toping.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.YearAdapter
import com.example.toping.model.Year
import kotlinx.android.synthetic.main.dialog_nationality.view.*

class YearFragment : DialogFragment() {

    private val year = ArrayList<Year>()
    private val adapter = YearAdapter(year)
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

        view.tvHeadingDialog.text = "Model yılını seçin"
        view.btnConfirm.setOnClickListener {
            result.value = adapter.result.value
        }

        return view
    }

    private fun dataInitialize() {
        year.add(Year(2015))
        year.add(Year(2016))
        year.add(Year(2017))
        year.add(Year(2018))
        year.add(Year(2015))
        year.add(Year(2016))
        year.add(Year(2017))
        year.add(Year(2018))
        year.add(Year(2015))
        year.add(Year(2016))
        year.add(Year(2017))
        year.add(Year(2018))
        year.add(Year(2015))
        year.add(Year(2016))
        year.add(Year(2017))
        year.add(Year(2018))
        year.add(Year(2015))
        year.add(Year(2016))
        year.add(Year(2017))
        year.add(Year(2018))
        year.add(Year(2015))
        year.add(Year(2016))
        year.add(Year(2017))
        year.add(Year(2018))
        year.add(Year(2015))
        year.add(Year(2016))
        year.add(Year(2017))
        year.add(Year(2018))
    }

}