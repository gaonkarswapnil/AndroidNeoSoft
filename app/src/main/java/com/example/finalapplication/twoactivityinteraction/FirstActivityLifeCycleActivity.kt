package com.example.finalapplication.twoactivityinteraction

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityFirstLifeCycleBinding

class FirstActivityLifeCycleActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirstLifeCycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFirstLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.btnNextActivity.setOnClickListener {
            Intent(this, SecondActivityLifeCycleActivity::class.java).also {
                startActivity(it)
            }
        }

        Toast.makeText(this,"Activity1 OnCreate() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity1 OnCreate() state")
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Activity1 OnStart() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity1 OnStart() state")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Activity1 OnResume() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity1 OnResume() state")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"Activity1 OnPause() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity1 OnPause() state")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"Activity1 OnStop() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity1 OnStop() state")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"Activity1 OnRestart() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity1 OnRestart() state")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Activity1 OnDestroy() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity1 OnDestroy() state")
    }
}