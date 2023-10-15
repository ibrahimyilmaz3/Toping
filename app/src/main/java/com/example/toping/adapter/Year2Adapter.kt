package com.example.toping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.model.Year2
import kotlinx.android.synthetic.main.item_text.view.*

class Year2Adapter(private val year: ArrayList<Year2>) :
    RecyclerView.Adapter<Year2Adapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()
    private var selected = -1

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

            tvCountry.text = year[position].year.toString()

            if (selected == position) {
                ivTick.visibility = View.VISIBLE
            } else {
                ivTick.visibility = View.INVISIBLE
            }

            setOnClickListener {
                selected = holder.adapterPosition
                result.value = tvCountry.text.toString()
                notifyDataSetChanged()
            }

        }

    }

    override fun getItemCount(): Int {
        return year.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}