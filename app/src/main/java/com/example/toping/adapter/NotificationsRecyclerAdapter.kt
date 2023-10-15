package com.example.toping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R

class NotificationsRecyclerAdapter: RecyclerView.Adapter<NotificationsRecyclerAdapter.ViewHolder>() {

    private var tripPrice = arrayListOf("500", "30000", "500", "30000", "500","500","500","500","500","500","500","500", "3000")

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationsRecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_notifications, parent, false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: NotificationsRecyclerAdapter.ViewHolder, position: Int) {
        holder.tvDate.text = tripPrice[position]
    }

    override fun getItemCount(): Int {
        return tripPrice.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvDate: TextView = itemView.findViewById(R.id.tvDate)
    }
}