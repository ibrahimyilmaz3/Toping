package com.example.toping.ui.dialog

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.example.toping.R
import com.example.toping.`object`.Main.paymentMethod
import com.example.toping.ui.activity.Card2Activity
import com.example.toping.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.dialog_reservation.view.*
import java.text.SimpleDateFormat
import java.util.*

class ReserveFragment : DialogFragment() {

    //private val adapter = DialogCityRecyclerAdapter()
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
        val view = inflater.inflate(R.layout.dialog_reservation, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp

        view.linearDate.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val dialog = DatePickerDialog(
                requireContext(),
                R.style.MyDatePickerDialogTheme,
                { _, year, month, day_of_month ->
                    calendar[Calendar.YEAR] = year
                    calendar[Calendar.MONTH] = month + 1
                    calendar[Calendar.DAY_OF_MONTH] = day_of_month
                    val myFormat = "dd/MM/yyyy"
                    val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
                    view.tvDate.text = sdf.format(calendar.time)
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            )
            dialog.datePicker.minDate = calendar.timeInMillis - 1000
            calendar.add(Calendar.YEAR, 0)
            //dialog.datePicker.maxDate = calendar.timeInMillis - 567648000000
            dialog.show()
        }

        view.frameHour.setOnClickListener {
            val hourFragment = HourFragment()
            hourFragment.show(parentFragmentManager, "hourFragment")
            hourFragment.result.observe(this) {
                view.tvHour.text = hourFragment.result.value
            }
        }

        view.frameMinute.setOnClickListener {
            val minuteFragment = MinuteFragment()
            minuteFragment.show(parentFragmentManager, "minuteFragment")
            minuteFragment.result.observe(this) {
                view.tvMinute.text = minuteFragment.result.value
            }
        }

        view.btnConfirm.setOnClickListener {
            if (paymentMethod == 1) {
                val intent = Intent(requireContext(), Card2Activity::class.java)
                startActivity(intent)
            } else if (paymentMethod == 2) {
                val intent = Intent(requireContext(), HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                Toast.makeText(requireContext(), "Rezervasyon oluşturuldu!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        return view
    }

}