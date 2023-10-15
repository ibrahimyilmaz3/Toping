package com.example.toping.adapter

import android.content.Context
import android.content.Intent
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.`object`.Phone
import com.example.toping.model.Tour
import com.example.toping.ui.activity.DetailActivity
import kotlinx.android.synthetic.main.item_tour.view.*

class TourAdapter(private val tour: ArrayList<Tour>) :
    RecyclerView.Adapter<TourAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()
    private var selected = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_tour, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.itemView) {


            tvName.text = tour[position].name
            tvPrice.text = tour[position].price
            tvDescription.text = tour[position].description
            ivFirst.setImageDrawable(ContextCompat.getDrawable(context,tour[position].picture1))
            ivSecond.setImageDrawable(ContextCompat.getDrawable(context,tour[position].picture2))
            ivThird.setImageDrawable(ContextCompat.getDrawable(context,tour[position].picture3))

            btnDetail.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("name", tour[holder.adapterPosition].name)
                context.startActivity(intent)
            }

        }
    }


    override fun getItemCount(): Int {
        return tour.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
