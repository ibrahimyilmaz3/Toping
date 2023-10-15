package com.example.toping.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.ui.activity.DriverRequestDetailActivity
import kotlinx.android.synthetic.main.item_request_driver.view.*

class DriverRequestRecyclerAdapter :
    RecyclerView.Adapter<DriverRequestRecyclerAdapter.ViewHolder>() {

    private var requestPrice =
        arrayListOf("Detaylar", "Detaylar", "Detaylar", "Detaylar", "Detaylar", "Detaylar")
    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DriverRequestRecyclerAdapter.ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_request_driver, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: DriverRequestRecyclerAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            tvRequestDetail.text = requestPrice[position]
            cardMainRequest.setOnClickListener {
                val intent =
                    Intent(context as AppCompatActivity, DriverRequestDetailActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return requestPrice.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}