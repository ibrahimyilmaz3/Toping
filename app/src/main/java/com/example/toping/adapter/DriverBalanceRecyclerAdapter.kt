package com.example.toping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.model.Trip2
import kotlinx.android.synthetic.main.item_trips.view.*

class DriverBalanceRecyclerAdapter(private val trip: ArrayList<Trip2>) :
    RecyclerView.Adapter<DriverBalanceRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DriverBalanceRecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_trips, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: DriverBalanceRecyclerAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            tvPrice.text = trip[position].price
            tvDate.text = trip[position].date
        }
    }

    override fun getItemCount(): Int {
        return trip.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}