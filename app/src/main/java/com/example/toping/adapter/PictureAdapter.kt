package com.example.toping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.model.Model
import com.example.toping.model.Tour
import kotlinx.android.synthetic.main.item_picture.view.*

class PictureAdapter(private val tour: ArrayList<Tour>) :
    RecyclerView.Adapter<PictureAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()
    val arrayCountry2 = ArrayList<String>()
    private var selected = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.itemView) {

            ivPicture.setImageDrawable(ContextCompat.getDrawable(context, tour[position].picture1))


        }

    }

    override fun getItemCount(): Int {
        return tour.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
