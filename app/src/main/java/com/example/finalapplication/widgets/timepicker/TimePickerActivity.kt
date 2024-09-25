package com.example.finalapplication.widgets.timepicker

import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapplication.databinding.ActivityTimePickerBinding
import java.sql.Time

class TimePickerActivity : AppCompatActivity() {
    lateinit var binding: ActivityTimePickerBinding
    private val selectedDay = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        binding.btnTime.setOnClickListener {
            val selectedHour = selectedDay.get(Calendar.HOUR_OF_DAY)
            val selectorMinutes = selectedDay.get(Calendar.MINUTE)
            TimePickerDialog(this, { _, selectedHour: Int, selectorMinutes: Int ->
                selectedDay.set(Calendar.HOUR_OF_DAY, selectedHour)
                selectedDay.set(Calendar.MINUTE, selectorMinutes)
                binding.tvTime.text = "$selectedHour:$selectorMinutes"
            }, selectedHour, selectorMinutes, false ).show()
        }
    }
}