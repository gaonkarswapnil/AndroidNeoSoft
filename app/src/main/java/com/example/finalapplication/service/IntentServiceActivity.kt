package com.example.finalapplication.service

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityIntentServiceBinding

class IntentServiceActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntentServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIntentServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartIntentService.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
//                startActivity(it)
                startService(it)
                binding.tvIntentService.text = "Service running"
            }
        }

        binding.btnStopIntentService.setOnClickListener {
            MyIntentService.onStopService()
        }
    }
}