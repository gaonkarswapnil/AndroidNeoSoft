package com.example.finalapplication.widgets.dateandtime

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapplication.databinding.ActivityDateAndTimeBinding
import java.util.Calendar

class DateAndTimeActivity : AppCompatActivity() {
    lateinit var binding: ActivityDateAndTimeBinding
    private val selectedDate = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDateAndTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.edDateSet.setOnClickListener {

            val selectedYear = selectedDate.get(Calendar.YEAR)
            val selectedMonth = selectedDate.get(Calendar.MONTH)
            val selectedDay = selectedDate.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                selectedDate.set(Calendar.YEAR, selectedYear)
                selectedDate.set(Calendar.MONTH, selectedMonth)
                selectedDate.set(Calendar.DAY_OF_MONTH, selectedDay)

                binding.edDateSet.setText("$selectedDay-$selectedMonth-$selectedYear/")
            }, selectedYear, selectedMonth, selectedDay).also {
                it.setCancelable(false)
            }.show()
        }

        binding.edTimeSet.setOnClickListener {
            val selectedHour = selectedDate.get(Calendar.HOUR_OF_DAY)
            val selectedMinutes = selectedDate.get(Calendar.MINUTE)
            TimePickerDialog(this, { _, selectedHour: Int, selectedMinutes: Int ->
                selectedDate.set(Calendar.HOUR_OF_DAY, selectedHour)
                selectedDate.set(Calendar.MINUTE, selectedMinutes)
                binding.edTimeSet.setText("$selectedHour:$selectedMinutes")
            }, selectedHour, selectedMinutes, false).also {
                it.setCancelable(false)
            }.show()
        }
    }
}