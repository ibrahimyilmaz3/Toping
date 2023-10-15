package com.example.toping.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.ui.activity.DriverTripDetailActivity

class DriverTripRecyclerAdapter : RecyclerView.Adapter<DriverTripRecyclerAdapter.ViewHolder>() {

    private var tripPrice = arrayListOf("500.00 TL", "300.00 TL", "500.00 TL", "300.00 TL", "500.00 TL", "300.00 TL")
    private lateinit var context: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DriverTripRecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_trips, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: DriverTripRecyclerAdapter.ViewHolder, position: Int) {
        holder.cardMainTrips.setOnClickListener {
            val intent = Intent(context as AppCompatActivity, DriverTripDetailActivity::class.java)
            context.startActivity(intent)
        }
        holder.tvPrice.text = tripPrice[position]
    }

    override fun getItemCount(): Int {
        return tripPrice.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardMainTrips: CardView = itemView.findViewById(R.id.cardMainTrips)
        var tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
    }
}