package com.example.toping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import kotlinx.android.synthetic.main.item_notifications.view.*

class DriverNotificationsRecyclerAdapter :
    RecyclerView.Adapter<DriverNotificationsRecyclerAdapter.ViewHolder>() {

    private var tripPrice = arrayListOf(
        Pair("Cuma, 14.04", "Yeni talebiniz var!"),
        Pair("Cuma, 13.04", "Yeni talebiniz var!"),
        Pair("Cuma, 12.04", "Yeni talebiniz var!"),
        Pair("Cuma, 11.04", "Yeni talebiniz var!"),
        Pair("Cuma, 10.04", "Yeni talebiniz var!"),
        Pair("Cuma, 09.04", "Yeni talebiniz var!"),
        Pair("Cuma, 07.04", "Yeni talebiniz var!"),
        Pair("Cuma, 06.04", "Yeni talebiniz var!"),
        Pair("Cuma, 05.04", "Yeni talebiniz var!"),
        Pair("Cuma, 04.04", "Yeni talebiniz var!"),
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DriverNotificationsRecyclerAdapter.ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_notifications, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: DriverNotificationsRecyclerAdapter.ViewHolder,
        position: Int
    ) {
        with(holder.itemView) {
            tvDate.text = tripPrice[position].first
            tvText.text = tripPrice[position].second
        }
    }

    override fun getItemCount(): Int {
        return tripPrice.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}