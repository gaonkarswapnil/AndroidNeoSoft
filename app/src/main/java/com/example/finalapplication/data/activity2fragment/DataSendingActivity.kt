package com.example.finalapplication.data.activity2fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityDataSendingBinding

class DataSendingActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataSendingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDataSendingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val DataRecievingFragment = DataRecievingFragment()

//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.flFragmentData, DataRecievingFragment)
//            commit()
//        }

        binding.btnSendData.setOnClickListener {
            val data = binding.etEnterText.text.toString()
            val bundle = Bundle().apply {
                putString("EXTRA_STRING", data)
            }
            DataRecievingFragment.arguments = bundle
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragmentData, DataRecievingFragment)
                addToBackStack(null)
                commit()
            }
        }

    }
}