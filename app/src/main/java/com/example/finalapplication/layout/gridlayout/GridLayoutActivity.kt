package com.example.finalapplication.layout.gridlayout

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityGridLayoutBinding

class GridLayoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityGridLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGridLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvCard1.setOnClickListener{
            Intent(this, GridLayoutNextActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}