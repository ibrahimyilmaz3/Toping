package com.example.toping.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.ui.activity.OfferDetailActivity
import kotlinx.android.synthetic.main.item_offers.view.*

class OffersRecyclerAdapter : RecyclerView.Adapter<OffersRecyclerAdapter.ViewHolder>() {

    private val list = ArrayList<Int>()
    private var offerDesc = arrayListOf(
        "Pegasus uçak biletlerinde kampanya 5",
        "Pegasus uçak biletlerinde kampanya 4",
        "Pegasus uçak biletlerinde kampanya 3",
        "Pegasus uçak biletlerinde kampanya 2",
        "Pegasus uçak biletlerinde kampanya 1"
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OffersRecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_offers, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: OffersRecyclerAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            tvOffer.text = offerDesc[position]

            //checkbox.isChecked = list.contains(position)

            Log.d("listValue", list.toString())

            /*if (list.contains(position)) checkbox.buttonTintList =
                ContextCompat.getColorStateList(context, R.color.blue)
            else checkbox.buttonTintList = ContextCompat.getColorStateList(context, R.color.gray)*/

            /*checkbox.setOnClickListener {
                if (list.contains(holder.adapterPosition)) list.remove(holder.adapterPosition)
                else list.add(holder.adapterPosition)
                notifyDataSetChanged()
            }*/
            btnJoin.setOnClickListener {
                val intent = Intent(context, OfferDetailActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return offerDesc.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}