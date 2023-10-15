package com.example.toping.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toping.R
import com.example.toping.adapter.DriverBalanceRecyclerAdapter
import com.example.toping.model.Trip2
import com.example.toping.service.MenuHandlerDriver
import com.example.toping.service.Tools
import kotlinx.android.synthetic.main.activity_driver_balance.*
import kotlinx.android.synthetic.main.activity_driver_balance.drawerLayoutDriver
import kotlinx.android.synthetic.main.activity_driver_home.*
import kotlinx.android.synthetic.main.activity_driver_home.navigationView
import kotlinx.android.synthetic.main.custom_top.*
import kotlinx.android.synthetic.main.item_trips.*
import java.text.SimpleDateFormat
import java.util.*

class DriverBalanceActivity : AppCompatActivity() {

    private val trip = ArrayList<Trip2>()
    private val trip2 = ArrayList<Trip2>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_balance)
        Tools().whiteStatusBar(this, window)
        MenuHandlerDriver(this, navigationView, drawerLayoutDriver, "DriverBalanceActivity")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        dataInitialize()

        tvHeading.text = "Cari Bilgilerim"
        cardBack.setOnClickListener {
            finish()
        }

        rvBalanceDriver.layoutManager = LinearLayoutManager(this)
        rvBalanceDriver.adapter = DriverBalanceRecyclerAdapter(trip)

        cardStart.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val dialog = DatePickerDialog(
                this,
                R.style.MyDatePickerDialogTheme,
                { _, year, month, day_of_month ->
                    calendar[Calendar.YEAR] = year
                    calendar[Calendar.MONTH] = month + 1
                    calendar[Calendar.DAY_OF_MONTH] = day_of_month
                    val myFormat = "dd/MM/yyyy"
                    val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
                    tvStart.text = sdf.format(calendar.time)
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            )
            //dialog.datePicker.minDate = calendar.timeInMillis - 3153600000000
            calendar.add(Calendar.YEAR, 0)
            //dialog.datePicker.maxDate = calendar.timeInMillis - 567648000000
            dialog.show()
        }

        cardEnd.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val dialog = DatePickerDialog(
                this,
                R.style.MyDatePickerDialogTheme,
                { _, year, month, day_of_month ->
                    calendar[Calendar.YEAR] = year
                    calendar[Calendar.MONTH] = month + 1
                    calendar[Calendar.DAY_OF_MONTH] = day_of_month
                    val myFormat = "dd/MM/yyyy"
                    val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
                    tvEnd.text = sdf.format(calendar.time)
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            )
            //dialog.datePicker.minDate = calendar.timeInMillis - 3153600000000
            calendar.add(Calendar.YEAR, 0)
            //dialog.datePicker.maxDate = calendar.timeInMillis - 567648000000
            dialog.show()
        }

        cardSearch.setOnClickListener {
            trip2.clear()
            for (i in trip) {
                if (i.date.substring(0, 2).toIntOrNull() == null && i.date.substring(0, 1)
                        .toInt() >= tvStart.text.toString().substring(0, 2)
                        .toInt() && i.date.substring(0, 1).toInt() <= tvEnd.text.toString()
                        .substring(0, 2).toInt()
                ) {
                    trip2.add(i)
                }
                if (i.date.substring(0, 2).toIntOrNull() != null && i.date.substring(0, 2)
                        .toInt() >= tvStart.text.toString().substring(0, 2)
                        .toInt() && i.date.substring(0, 2).toInt() <= tvEnd.text.toString()
                        .substring(0, 2).toInt()
                ) {
                    trip2.add(i)
                }
            }
            rvBalanceDriver.adapter = DriverBalanceRecyclerAdapter(trip2)
            rvBalanceDriver.adapter!!.notifyDataSetChanged()
        }

    }

    private fun dataInitialize() {
        trip.add(
            Trip2(
                "1 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "2 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "3 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "4 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "5 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "6 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "7 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "8 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "9 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "10 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "11 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "12 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "13 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "14 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "15 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "15 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "16 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "17 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "18 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "19 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "21 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "22 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "23 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "24 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "25 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "26 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "27 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "28 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "29 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
        trip.add(
            Trip2(
                "30 Nisan 2023 - 15.43",
                "Halkalı Merkez Mahallesi, Dereboyu Cad.",
                "Yolculuk tamamlandı.",
                "500.00 TL"
            )
        )
    }
}