package com.example.toping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.model.Hour
import kotlinx.android.synthetic.main.item_text.view.*

class HourAdapter(private val hour: ArrayList<Hour>) :
    RecyclerView.Adapter<HourAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()

    private var arrayYear = arrayListOf(
        "00",
        "01",
        "02",
        "03",
        "04",
        "05",
        "06",
        "07",
        "08",
        "09",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "18",
        "19",
        "20",
        "21",
        "22",
        "23"
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.itemView) {
            tvCountry.text = hour[position].hour

            setOnClickListener {
                result.value = tvCountry.text.toString()
            }

        }
    }

    override fun getItemCount(): Int {
        return hour.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
