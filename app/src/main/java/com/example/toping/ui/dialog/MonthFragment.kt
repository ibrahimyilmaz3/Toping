package com.example.toping.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.MonthAdapter
import com.example.toping.model.Month
import kotlinx.android.synthetic.main.dialog_date2.view.*
import java.util.ArrayList

class MonthFragment : DialogFragment() {

    private val send = ArrayList<Month>()
    private val adapter = MonthAdapter(send)
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
        view.tvHeadingDialog.text = "Ay"
        adapter.result.observe(viewLifecycleOwner) {
            result.value = it
            dialog!!.dismiss()
        }
        return view
    }

    private fun dataInitialize() {
        send.add(Month("01"))
        send.add(Month("02"))
        send.add(Month("03"))
        send.add(Month("04"))
        send.add(Month("05"))
        send.add(Month("06"))
        send.add(Month("07"))
        send.add(Month("08"))
        send.add(Month("09"))
        send.add(Month("10"))
        send.add(Month("11"))
        send.add(Month("12"))
    }
}