package com.example.toping.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.example.toping.R
import kotlinx.android.synthetic.main.dialog_date.*
import kotlinx.android.synthetic.main.dialog_date.view.*

class DateFragment : DialogFragment() {

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
        val view = inflater.inflate(R.layout.dialog_date, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp

        /*view.rvDialog.adapter = adapter
        view.rvDialog.layoutManager = LinearLayoutManager(requireContext())*/
        /*adapter.result.observe(viewLifecycleOwner) {
            result.value = it
        }*/
/*
        view.tvHeadingDialog.text = "Kedinizin Kilosu"
        view.tvFirstInput.text = "Kilo"
        view.tvSecondInput.text = "Gram"
        view.tvYear.hint = "Kilo"
        view.tvMonth.hint = "Gram"*/

        view.linearYear.setOnClickListener {
            val year2Fragment = Year2Fragment()
            year2Fragment.show(parentFragmentManager, "year2Fragment")
            year2Fragment.result.observe(this) {
                tvYear.text = it
                run(view)
            }
        }

        view.linearMonth.setOnClickListener {
            val monthFragment = MonthFragment()
            monthFragment.show(parentFragmentManager, "monthFragment")
            monthFragment.result.observe(this) {
                tvMonth.text = it
                run(view)
            }
        }
        return view
    }

    private fun run(view: View) {
        if (view.tvYear.text.toString().isNotBlank() && view.tvMonth.text.toString().isNotBlank()) {
            val year = view.tvYear.text.toString()
            val year2 = year.removePrefix("20")
            result.value = view.tvMonth.text.toString() + " / " + year2
            dialog!!.dismiss()
        }
    }
}