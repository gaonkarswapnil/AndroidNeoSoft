package com.example.finalapplication.retrofitpost

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityRetrofitBinding
import com.example.finalapplication.databinding.ActivityRetrofitPostBinding
import kotlinx.coroutines.launch

class RetrofitPostActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetrofitPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRetrofitPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val registerAPI = RegisterRetrofitHelper.getInstance().create(RegisterAPI::class.java)

        lifecycleScope.launch {
            val register = Register("Swapnil", "Gaonkar", "gaonkarswapnil1@yahoo.com", "ABC@123", "ABC@123", "Male", 9022695479)

            val registerUser = registerAPI.createRegistration(register)
            Log.d("RetroFit Post", registerUser.body().toString())
        }
    }
}