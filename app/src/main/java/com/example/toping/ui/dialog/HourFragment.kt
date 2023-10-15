package com.example.toping.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.HourAdapter
import com.example.toping.model.Hour
import kotlinx.android.synthetic.main.dialog_date2.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class HourFragment : DialogFragment() {

    private val hour = ArrayList<Hour>()
    val result = MutableLiveData<String>()

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.9).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    @RequiresApi(Build.VERSION_CODES.O)
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

        val currentDateTime = LocalDateTime.now()
        val time = currentDateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
            .removeSuffix(" AM").removeSuffix(" PM")
        val currentHour = time.substring(0, 2).toIntOrNull()
        if (currentHour != null) {
            for (i in currentHour + 2..23) {
                val string = i.toString()
                hour.add(Hour(string))
            }
        }
        hour.add(hour.size, Hour("00"))

        val adapter = HourAdapter(hour)
        view.rvDialog.adapter = adapter
        view.rvDialog.layoutManager = LinearLayoutManager(requireContext())
        view.tvHeadingDialog.text = "Saat"
        adapter.result.observe(viewLifecycleOwner) {
            result.value = it
            dialog!!.dismiss()
        }
        return view
    }
}