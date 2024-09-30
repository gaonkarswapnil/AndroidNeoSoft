package com.example.finalapplication.data.activity2activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityDataRecievingBinding

class DataRecievingActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataRecievingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDataRecievingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        binding.tvDataRecieving.text = "${bundle?.getString("EXTRA_TEXT")} ${bundle?.getInt("EXTRA_INT")}"
    }
}