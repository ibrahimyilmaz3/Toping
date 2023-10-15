package com.example.toping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.model.Language
import kotlinx.android.synthetic.main.item_text.view.*

class LanguageAdapter(private val language: ArrayList<Language>) :
    RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()
    private val list = ArrayList<Int>()
    val arrayCountry2 = ArrayList<String>()

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

            tvCountry.text = language[position].language

            if (list.contains(position)) {
                ivTick.visibility = View.VISIBLE
            } else {
                ivTick.visibility = View.INVISIBLE
            }

            setOnClickListener {
                if (list.contains(position)) {
                    list.remove(position)
                    arrayCountry2.remove(language[position].language)
                } else {
                    list.add(position)
                    arrayCountry2.add(language[position].language)
                }
                notifyDataSetChanged()
            }

        }
    }

    override fun getItemCount(): Int {
        return language.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
