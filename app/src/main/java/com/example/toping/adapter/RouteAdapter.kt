package com.example.toping.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.`object`.Route.navRoute
import com.example.toping.model.Brand
import com.example.toping.model.Language
import com.example.toping.model.Route
import com.example.toping.ui.activity.ChooseActivity
import com.google.android.gms.common.internal.RootTelemetryConfigManager
import kotlinx.android.synthetic.main.activity_transfer.*
import kotlinx.android.synthetic.main.item_route.view.*

class RouteAdapter(private val route: ArrayList<Route>) :
    RecyclerView.Adapter<RouteAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_route, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.itemView) {

            tvText.text = route[position].route

            setOnClickListener {
                when (holder.adapterPosition) {
                    0 -> {
                        navRoute = 1
                        val intent = Intent(context, ChooseActivity::class.java)
                        context.startActivity(intent)
                    }
                    route.size -1 -> {
                        navRoute = 3
                        val intent = Intent(context, ChooseActivity::class.java)
                        context.startActivity(intent)
                    }
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return route.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
