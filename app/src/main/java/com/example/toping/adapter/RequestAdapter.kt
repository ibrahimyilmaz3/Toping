package com.example.toping.adapter

import android.content.Context
import android.content.Intent
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.toping.R
import com.example.toping.model.Request
import com.example.toping.ui.activity.Detail2Activity
import com.example.toping.ui.activity.Detail4Activity
import kotlinx.android.synthetic.main.item_tour2.view.*
import kotlinx.android.synthetic.main.item_trip.view.*

class RequestAdapter(private val request: ArrayList<Request>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item_trip -> Trip(view.inflate(viewType, parent, false))
            R.layout.item_tour2 -> Tour2(view.inflate(viewType, parent, false))
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder.itemView) {
            when (request[position].type) {

                "Tur" -> {
                    tvID_tour2.text = request[position].type
                    tvPrice_tour2.text = request[position].tour!!.price
                    tvName_tour2.text = request[position].tour!!.name
                    tvDescription_tour2.text = request[position].tour!!.description

                    val str1 = "Rezervasyon Tarihi: ${request[position].tour!!.date}"
                    val span1 = SpannableString(str1)
                    span1.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        19,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvDate_tour2.text = span1

                    val str3 = "Rezervasyon Saati: ${request[position].tour!!.hour}"
                    val span3 = SpannableString(str3)
                    span3.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        18,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvHour_tour2.text = span3

                    val str5 = "Ödeme Türü: ${request[position].tour!!.payment}"
                    val span5 = SpannableString(str5)
                    span5.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        11,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvPayment_tour2.text = span5

                    btnDetail_tour2.setOnClickListener {
                        val intent = Intent(context, Detail2Activity::class.java)
                        context.startActivity(intent)
                    }
                }
                "Transfer" -> {
                    tvName.text = request[position].type
                    tvPrice.text = request[position].trip!!.price

                    val str10 = "Başlangıç Noktası: ${request[position].trip!!.start}"
                    val span10 = SpannableString(str10)
                    span10.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        18,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvStart.text = span10

                    val str9 = "Durak Noktası 1: ${request[position].trip!!.stop1}"
                    val span9 = SpannableString(str9)
                    span9.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        16,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvStop1.text = span9

                    val str8 = "Durak Noktası 2: ${request[position].trip!!.stop2}"
                    val span8 = SpannableString(str8)
                    span8.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        16,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvStop2.text = span8

                    val str7 = "Varış Noktası: ${request[position].trip!!.destination}"
                    val span7 = SpannableString(str7)
                    span7.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        14,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvDestination.text = span7

                    val str2 = "Rezervasyon Tarihi: ${request[position].trip!!.date}"
                    val span2 = SpannableString(str2)
                    span2.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        19,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvDate.text = span2

                    val str4 = "Rezervasyon Saati: ${request[position].trip!!.hour}"
                    val span4 = SpannableString(str4)
                    span4.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        18,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvHour.text = span4

                    tvPrice.text = request[position].trip!!.price

                    val str6 = "Ödeme Türü: ${request[position].trip!!.payment}"
                    val span6 = SpannableString(str6)
                    span6.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)),
                        0,
                        11,
                        Spannable.SPAN_INCLUSIVE_INCLUSIVE
                    )
                    tvPayment.text = span6

                    btnDetail.setOnClickListener {
                        val intent = Intent(context, Detail4Activity::class.java)
                        context.startActivity(intent)
                    }
                }
                else -> throw IllegalArgumentException("Wrong type")
            }
        }
    }

    override fun getItemCount(): Int {
        return request.size
    }

    override fun getItemViewType(position: Int): Int {

        return when (request[position].type) {
            "Tur" -> {
                R.layout.item_tour2
            }
            "Transfer" -> {
                R.layout.item_trip
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    inner class Trip(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class Tour2(itemView: View) : RecyclerView.ViewHolder(itemView)
}