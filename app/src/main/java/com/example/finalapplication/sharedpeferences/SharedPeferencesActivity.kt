package com.example.finalapplication.sharedpeferences

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivitySharedPeferencesBinding

class SharedPeferencesActivity : AppCompatActivity() {
    lateinit var binding: ActivitySharedPeferencesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySharedPeferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val savePreference = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = savePreference.edit()

        binding.btnSavePreferenceData.setOnClickListener {
            val etName = binding.etName.text.toString()
            val etAge = binding.etAge.text.toString().toInt()
            val cbIsAdult = binding.cbIsAdult.isChecked

            editor.apply {
                putString("name", etName)
                putInt("age", etAge)
                putBoolean("isAdult", cbIsAdult)
                apply()
            }

        }

        binding.btnLoadSavePreference.setOnClickListener {
            val name = savePreference.getString("name", null);
            val age = savePreference.getInt("age", 0)
            val isAdult = savePreference.getBoolean("isAdult", false)

            binding.etName.setText(name);
            binding.etAge.setText(age.toString())
            binding.cbIsAdult.isChecked = isAdult
        }
    }
}