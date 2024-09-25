package com.example.finalapplication.widgets.togglebutton

import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityToggleButtonBinding
import com.example.finalapplication.databinding.ActivityTwoSpinnerBinding

class ToggleButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityToggleButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToggleButtonBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        binding.toggleBtnSimple.setOnCheckedChangeListener { compoundButton, isChecked: Boolean ->
            if(isChecked){
                Toast.makeText(this, "Toggle Button On", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Toggle Button OFF", Toast.LENGTH_SHORT).show()
            }
        }
    }
}