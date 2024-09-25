package com.example.finalapplication.widgets.datepicker

import android.app.DatePickerDialog
import android.os.Bundle
import android.provider.CalendarContract.CalendarAlerts
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityDateDifferenceBinding
import java.util.Calendar

class DateDifferenceActivity : AppCompatActivity() {
    lateinit var binding: ActivityDateDifferenceBinding
    val selectedDate = Calendar.getInstance()
    val firstSelectedDate = Calendar.getInstance()
    val secondSelectedDate = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDateDifferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFirstDate.setOnClickListener {
            val year = firstSelectedDate.get(Calendar.YEAR)
            val month = firstSelectedDate.get(Calendar.MONTH)
            val day =firstSelectedDate.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                firstSelectedDate.set(Calendar.YEAR, selectedYear)
                firstSelectedDate.set(Calendar.MONTH, selectedMonth)
                firstSelectedDate.set(Calendar.DAY_OF_MONTH, selectedDay)
                binding.txtFirstDate.text = "$selectedYear/${selectedMonth+1}/$selectedDay"
            }, year, month, day).also{
                it.setCancelable(false)
            }.show()


        }

        binding.btnSecondDate.setOnClickListener {
            val year = secondSelectedDate.get(Calendar.YEAR)
            val month = secondSelectedDate.get(Calendar.MONTH)
            val day = secondSelectedDate.get(Calendar.DAY_OF_MONTH)

            val dateDetails = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                secondSelectedDate.set(Calendar.YEAR, selectedYear)
                secondSelectedDate.set(Calendar.MONTH, selectedMonth)
                secondSelectedDate.set(Calendar.DAY_OF_MONTH, selectedDay)
                binding.tvDateDifference.text = "$selectedYear/${selectedMonth+1}/$selectedDay"
            }, year, month, day).also {
                it.setCancelable(false)
                it.datePicker.minDate = firstSelectedDate.timeInMillis
            }.show()

//            binding.tvDateDifference.text = "${dateDetails.toString()}"
        }

    }
}