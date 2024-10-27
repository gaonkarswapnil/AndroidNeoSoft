package com.example.finalapplication.onsavedinstancestate

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityOnSavedInstanceBinding
import com.example.finalapplication.databinding.ActivityRealmBinding

class OnSavedInstanceActivity : AppCompatActivity() {
    lateinit var binding: ActivityOnSavedInstanceBinding
//    private lateinit var editText: EditText
    private var counter: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnSavedInstanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        editText = findViewById(R.id.etTempData)

//        binding.tvCounter.text = counter.toString()

        binding.btnCounter.setOnClickListener {
            counter+=1;
            binding.tvCounter.text = counter.toString()
        }



        savedInstanceState?.let {
            binding.etTempData.setText(it.getString("saved_text"))
            counter = it.getInt("saved_number")
            binding.tvCounter.text = counter.toString()
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved_text", binding.etTempData.text.toString())
        outState.putInt("saved_number", counter)
    }

    
}