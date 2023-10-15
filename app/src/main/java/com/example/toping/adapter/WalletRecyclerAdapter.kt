package com.example.toping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R

class WalletRecyclerAdapter : RecyclerView.Adapter<WalletRecyclerAdapter.ViewHolder>() {

    private var tripPrice = arrayListOf("500.00", "300.00", "500.00", "300.00", "500.00", "300.00")
    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WalletRecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_wallet, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: WalletRecyclerAdapter.ViewHolder, position: Int) {
        holder.tvPrice.text = tripPrice[position]
    }

    override fun getItemCount(): Int {
        return tripPrice.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
    }
}