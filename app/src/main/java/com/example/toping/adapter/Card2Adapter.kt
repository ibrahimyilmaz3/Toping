package com.example.toping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.`object`.Main.cardSelected
import com.example.toping.model.CardNumber
import com.example.toping.ui.activity.Card2Activity
import com.example.toping.ui.activity.CardActivity
import kotlinx.android.synthetic.main.item_card.view.*
import kotlinx.android.synthetic.main.item_card.view.tvCardNumber
import kotlinx.android.synthetic.main.item_card2.view.*

class Card2Adapter(private val number: ArrayList<CardNumber>) :
    RecyclerView.Adapter<Card2Adapter.ViewHolder>() {

    private var selected = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Card2Adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_card2, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Card2Adapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            tvCardNumber.text = number[position].number

            if (selected == holder.adapterPosition) {
                ivToggle.visibility = View.VISIBLE
            } else {
                ivToggle.visibility = View.GONE
            }

            setOnClickListener {
                cardSelected = 1
                selected = holder.adapterPosition
                notifyDataSetChanged()
            }

        }
    }

    override fun getItemCount(): Int {
        return number.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
