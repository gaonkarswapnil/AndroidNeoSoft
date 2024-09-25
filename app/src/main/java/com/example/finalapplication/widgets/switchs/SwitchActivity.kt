package com.example.finalapplication.widgets.switchs

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivitySwitchBinding

class SwitchActivity : AppCompatActivity() {
    lateinit var binding: ActivitySwitchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySwitchBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.switchSlider.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                Toast.makeText(this, "Switch is On", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Switch if Off", Toast.LENGTH_SHORT).show()
            }
        }
    }
}