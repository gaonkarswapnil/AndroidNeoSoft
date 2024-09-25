package com.example.finalapplication.activitylifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R

class ActivityLifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        Toast.makeText(this, "OnCreate() state", Toast.LENGTH_SHORT).show()
        Log.d("Activity_LifeCycle", "OnCreate() state ");
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "OnStart() state", Toast.LENGTH_SHORT).show()
        Log.d("Activity_LifeCycle", "OnStart() state ");
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "OnResume() state", Toast.LENGTH_SHORT).show()
        Log.d("Activity_LifeCycle", "OnResume() state ");
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "OnStop() state", Toast.LENGTH_SHORT).show()
        Log.d("Activity_LifeCycle", "OnStop() state ");
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "OnPause() state", Toast.LENGTH_SHORT).show()
        Log.d("Activity_LifeCycle", "OnPause() state ")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "OnRestart() state", Toast.LENGTH_SHORT).show()
        Log.d("Activity_LifeCycle", "OnRestart() state ");
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "OnDestroy() state", Toast.LENGTH_SHORT).show()
        Log.d("Activity_LifeCycle", "OnDestroy() state ");
    }
}