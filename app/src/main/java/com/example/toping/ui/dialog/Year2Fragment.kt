package com.example.toping.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.Year2Adapter
import com.example.toping.model.Year2
import kotlinx.android.synthetic.main.dialog_date2.view.*

class Year2Fragment : DialogFragment() {

    private val send = ArrayList<Year2>()
    private val adapter = Year2Adapter(send)
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
        val view = inflater.inflate(R.layout.dialog_date2, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp

        dataInitialize()

        view.rvDialog.adapter = adapter
        view.rvDialog.layoutManager = LinearLayoutManager(requireContext())
        view.tvHeadingDialog.text = "Yıl"
        adapter.result.observe(viewLifecycleOwner) {
            result.value = it
            dialog!!.dismiss()
        }
        return view
    }

    private fun dataInitialize() {
        send.add(Year2(2023))
        send.add(Year2(2024))
        send.add(Year2(2025))
        send.add(Year2(2026))
        send.add(Year2(2027))
        send.add(Year2(2028))
        send.add(Year2(2029))
        send.add(Year2(2030))
        send.add(Year2(2031))
        send.add(Year2(2032))
        send.add(Year2(2033))
        send.add(Year2(2034))
        send.add(Year2(2035))
        send.add(Year2(2036))
        send.add(Year2(2037))
        send.add(Year2(2038))
        send.add(Year2(2039))
        send.add(Year2(2040))
    }
}