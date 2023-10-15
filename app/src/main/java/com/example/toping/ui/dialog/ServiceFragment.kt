package com.example.toping.ui.dialog

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.example.toping.R
import com.example.toping.ui.activity.TourActivity
import com.example.toping.ui.activity.TransferActivity
import kotlinx.android.synthetic.main.dialog_choose_service.view.*

class ServiceFragment : DialogFragment() {

    val result = MutableLiveData<String>()
    private var selected = 0 //tour

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
        val view = inflater.inflate(R.layout.dialog_choose_service, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp

        view.btnContinue.setOnClickListener {
            if (selected == 0) {
                val intent = Intent(requireContext(), TourActivity::class.java)
                requireContext().startActivity(intent)
            } else {
                val intent = Intent(requireContext(), TransferActivity::class.java)
                requireContext().startActivity(intent)
            }
            dialog!!.dismiss()
        }

        view.linearTour.setBackgroundResource(R.drawable.round_10_blue_corner_solid_light_gray)
        view.linearTour.setOnClickListener {
            view.linearTour.setBackgroundResource(R.drawable.round_10_blue_corner_solid_light_gray)
            view.linearTransfer.setBackgroundResource(R.drawable.round_10_light_gray)
            selected = 0
        }
        view.linearTransfer.setOnClickListener {
            view.linearTour.setBackgroundResource(R.drawable.round_10_light_gray)
            view.linearTransfer.setBackgroundResource(R.drawable.round_10_blue_corner_solid_light_gray)
            selected = 1
        }

        return view
    }
}