package com.example.toping.ui.dialog

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.example.toping.R
import com.example.toping.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.dialog_cancel.view.*

class CancelFragment : DialogFragment() {

    val result = MutableLiveData<String>()
    private var selected = 0

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
        val view = inflater.inflate(R.layout.dialog_cancel, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.BOTTOM
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp

        view.btnKeepDialog.setOnClickListener {
            dialog!!.dismiss()
        }
        view.btnCancelDialog.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            requireContext().startActivity(intent)
            dialog!!.dismiss()
        }

        return view
    }
}