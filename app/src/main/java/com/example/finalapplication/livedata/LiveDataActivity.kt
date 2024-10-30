package com.example.finalapplication.livedata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {
    lateinit var liveDataViewModel: LiveDataViewModel

    lateinit var binding: ActivityLiveDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val factory = LiveDataViewModelFactory(data)
        liveDataViewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        liveDataViewModel.factDataText.observe(this, Observer {
            binding.tvLiveData.text = it
        })

        binding.btnLiveDataButton.setOnClickListener {
            val data = binding.etLiveDataEdit.text.toString()
            liveDataViewModel.updateText(data)
        }
    }
}