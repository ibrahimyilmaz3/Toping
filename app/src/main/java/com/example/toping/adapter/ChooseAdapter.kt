package com.example.toping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.`object`.Route.route
import com.example.toping.`object`.Route.route2
import com.example.toping.model.Choose
import com.example.toping.model.Route
import kotlinx.android.synthetic.main.item_route.view.*

class ChooseAdapter(private val choose: ArrayList<Choose>) :
    RecyclerView.Adapter<ChooseAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()

    private var selected = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_choose, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.itemView) {

            tvText.text = choose[position].choose

            if (selected == position) {
                tvText.setTextColor(ContextCompat.getColor(context,R.color.blue))
            } else {
                tvText.setTextColor(ContextCompat.getColor(context,R.color.color_959595))
            }

            setOnClickListener {
                tvText.setTextColor(ContextCompat.getColor(context,R.color.blue))
                selected = holder.adapterPosition
                route2 = tvText.text.toString()
                notifyDataSetChanged()
                //Toast.makeText(context, "${result.value}", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun getItemCount(): Int {
        return choose.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
