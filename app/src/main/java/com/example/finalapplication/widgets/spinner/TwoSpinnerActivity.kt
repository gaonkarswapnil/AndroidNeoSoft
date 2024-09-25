package com.example.finalapplication.widgets.spinner

import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityTwoSpinnerBinding

class TwoSpinnerActivity : AppCompatActivity() {
    lateinit var binding: ActivityTwoSpinnerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTwoSpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val items = listOf("Mumbai", "Thane", "Raigad")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFixedData.adapter = adapter;

        binding.spinnerFixedData.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    val selectedItem = parent?.getItemAtPosition(position)
                    val result = when (selectedItem) {
                        "Mumbai" -> listOf("CSMT", "Byculla", "Dadar", "Kurla", "Ghatkopar")
                        "Thane" -> listOf("Thane", "Dombivli", "Kalyan", "Ambernath", "Badlapur")
                        "Raigad" -> listOf("Karjat", "Khopoli", "Matheran")
                        else -> { emptyList<String>() }
                    }
                    val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, result)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.spinnerInteractiveData.adapter = adapter
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
    }
}