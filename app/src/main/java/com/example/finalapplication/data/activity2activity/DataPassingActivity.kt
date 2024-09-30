package com.example.finalapplication.data.activity2activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityDataPassingBinding

class DataPassingActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataPassingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDataPassingBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.btnSendDataActivity.setOnClickListener {
            val text = binding.tvDataPassing.text.toString()
            val no = binding.etAgeDataPassing.text.toString().toInt()
            val bundle = Bundle().apply {
                putString("EXTRA_TEXT", text);
                putInt("EXTRA_INT", no);
            }
            Intent(this, DataRecievingActivity::class.java).also{
                it.putExtras(bundle)
                startActivity(it)
            }
        }

    }
}