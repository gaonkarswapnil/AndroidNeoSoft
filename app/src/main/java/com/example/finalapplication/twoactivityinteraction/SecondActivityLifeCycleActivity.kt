package com.example.finalapplication.twoactivityinteraction

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivitySecondLifeCycleBinding

class SecondActivityLifeCycleActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondLifeCycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.btnBackToFirstActivity.setOnClickListener {
            finish()
        }

        Toast.makeText(this,"Activity2 OnCreate() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity2 OnCreate() state")
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Activity2 OnStart() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity2 OnStart() state")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Activity2 OnResume() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity2 OnResume() state")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"Activity2 OnPause() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity2 OnPause() state")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"Activity2 OnStop() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity2 OnStop() state")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"Activity2 OnRestart() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity2 OnRestart() state")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Activity2 OnDestroy() state", Toast.LENGTH_SHORT).show()
        Log.d("InteractiveLifeCycle", "Activity2 OnDestroy() state")
    }
}