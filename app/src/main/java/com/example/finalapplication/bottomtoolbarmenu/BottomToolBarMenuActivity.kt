package com.example.finalapplication.bottomtoolbarmenu

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityBottomToolBarMenuBinding

class BottomToolBarMenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityBottomToolBarMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBottomToolBarMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment)

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.miHome -> {
                    setCurrentFragment(firstFragment)
                    true
                }

                R.id.miMessage -> {
                    setCurrentFragment(secondFragment)
                    true
                }

                R.id.miProfile -> {
                    setCurrentFragment(thirdFragment)
                    true
                }

                else -> {
                    false
                }
            }

        }

        binding.bottomNavigationView.getOrCreateBadge(R.id.miMessage).apply {
            number = 10
            isVisible = true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragmentBottomToolBarMenu, fragment)
            commit();
        }

}