package com.example.toping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.model.CardNumber
import kotlinx.android.synthetic.main.item_card.view.*

class CardAdapter(private val number: ArrayList<CardNumber>) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CardAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            tvCardNumber.text = number[position].number
        }

    }

    override fun getItemCount(): Int {
        return number.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
