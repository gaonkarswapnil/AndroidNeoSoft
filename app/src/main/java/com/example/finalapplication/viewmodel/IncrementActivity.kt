package com.example.finalapplication.viewmodel

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityIncrementBinding

class IncrementActivity : AppCompatActivity() {
    lateinit var binding: ActivityIncrementBinding
    lateinit var viewModel: IncrementViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIncrementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = IncrementViewModelFactory(10)
        viewModel = ViewModelProvider(this, factory).get(IncrementViewModel::class.java)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        setUp()
        binding.btnIncrement.setOnClickListener {
            viewModel.increment()

            setUp()
        }

    }

//    fun increment(v: View){
//        viewModel.increment()
//        setUp()
//    }

    private fun setUp() {
        binding.tvIncrement.text = viewModel.count.toString()

    }
}