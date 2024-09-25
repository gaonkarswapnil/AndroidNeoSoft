package com.example.finalapplication.fragmentlifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityFragmentBinding
import com.example.finalapplication.databinding.ActivityFragmentLifeCycleBinding

class FragmentLifeCycleActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentLifeCycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFragmentLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val firstFragment = FirstLifeCycleFragment()
        val secondFragment = SecondLifeCycleFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragmentLifeCycle, firstFragment)
            commit()
        }

        binding.btnFirstFragmentLifeCycle.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragmentLifeCycle, firstFragment)
                commit()
            }
        }

        binding.btnSecondFragmentLifeCycle.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragmentLifeCycle, secondFragment)
                commit()
                addToBackStack(null)
            }
        }
        Toast.makeText(this, "Activity onCreate() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Activity onCreate() state")
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Activity onStart() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Activity onStart() state")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Activity onResume() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Activity onResume() state")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Activity onPause() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Activity onPause() state")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Activity onStop() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Activity onStop() state")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Activity onRestart() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Activity onRestart() state")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Activity onDestroy() state", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifeCycle","Activity onDestroy() state")
    }
}