package com.example.finalapplication.data

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.data.activity2activity.DataPassingActivity
import com.example.finalapplication.data.activity2fragment.DataSendingActivity
import com.example.finalapplication.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.btnActivity2Activity.setOnClickListener {
            Intent(this, DataPassingActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnActivity2Fragment.setOnClickListener {
            Intent(this, DataSendingActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnFragment2Activity.setOnClickListener {

        }

        binding.btnFragment2Fragment.setOnClickListener {

        }
    }
}