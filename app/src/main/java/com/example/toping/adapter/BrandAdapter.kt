package com.example.toping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.model.Brand
import kotlinx.android.synthetic.main.item_text.view.*

class BrandAdapter(private val brand: ArrayList<Brand>) :
    RecyclerView.Adapter<BrandAdapter.ViewHolder>() {

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

            tvCountry.text = brand[position].brand

            if (selected == position) {
                ivTick.visibility = View.VISIBLE
            } else {
                ivTick.visibility = View.INVISIBLE
            }

            setOnClickListener {
                selected = holder.adapterPosition
                result.value = brand[selected].brand
                notifyDataSetChanged()
            }

        }
    }

    override fun getItemCount(): Int {
        return brand.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
