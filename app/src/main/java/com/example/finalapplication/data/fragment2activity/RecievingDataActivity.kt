package com.example.finalapplication.data.fragment2activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityDataRecievingBinding
import com.example.finalapplication.databinding.ActivityRecievingDataBinding

class RecievingDataActivity : AppCompatActivity(), MyInterface {
    lateinit var binding: ActivityRecievingDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecievingDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val DataSendingFragment = DataSendingFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragmentDataSending, DataSendingFragment)
            commit()
        }

    }

    override fun transferredMsg(msg: String) {
        binding.tvActivityDataRevieved.text = msg
    }
}