package com.example.finalapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapplication.activitylifecycle.ActivityLifeCycleActivity
import com.example.finalapplication.bottomtoolbarmenu.BottomToolBarMenuActivity
import com.example.finalapplication.databinding.ActivityMainBinding
import com.example.finalapplication.fragment.FragmentActivity
import com.example.finalapplication.fragmentlifecycle.FragmentLifeCycleActivity
import com.example.finalapplication.toolbarmenu.ToolBarMenuActivity
import com.example.finalapplication.twoactivityinteraction.FirstActivityLifeCycleActivity
import com.example.finalapplication.viewpager2.ViewPager2Activity
import com.example.finalapplication.widgets.alertdialog.AlertDialogActivity
import com.example.finalapplication.widgets.customdialog.CustomDialogActivity
import com.example.finalapplication.widgets.dateandtime.DateAndTimeActivity
import com.example.finalapplication.widgets.datepicker.DateDifferenceActivity
import com.example.finalapplication.widgets.datepicker.DatePickerActivity
import com.example.finalapplication.widgets.recyclerview.RecyclerViewActivity
import com.example.finalapplication.widgets.spinner.SpinnerActivity
import com.example.finalapplication.widgets.spinner.TwoSpinnerActivity
import com.example.finalapplication.widgets.switchs.SwitchActivity
import com.example.finalapplication.widgets.timepicker.TimePickerActivity
import com.example.finalapplication.widgets.togglebutton.ToggleButtonActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        binding.btnActivityLifeCycle.setOnClickListener {
            Intent(this, ActivityLifeCycleActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnTwoActivityInteraction.setOnClickListener {
            Intent(this, FirstActivityLifeCycleActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnFragment.setOnClickListener {
            Intent(this, FragmentActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnFragmentLifeCycle.setOnClickListener {
            Intent(this, FragmentLifeCycleActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnBasicSpinner.setOnClickListener {
            Intent(this, SpinnerActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnTwoSpinnerActivity.setOnClickListener {
            Intent(this, TwoSpinnerActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnToggleButton.setOnClickListener {
            Intent(this, ToggleButtonActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnSwitchSlider.setOnClickListener {
            Intent(this, SwitchActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnToolBar.setOnClickListener {
            Intent(this, ToolBarMenuActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnAlertDialog.setOnClickListener {
            Intent(this, AlertDialogActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnDatePicker.setOnClickListener {
            Intent(this, DatePickerActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnDateDifference.setOnClickListener {
            Intent(this, DateDifferenceActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnCustomDialog.setOnClickListener {
            Intent(this, CustomDialogActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnRecyclerViewTodo.setOnClickListener {
            Intent(this, RecyclerViewActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnTimePicker.setOnClickListener {
            Intent(this, TimePickerActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnDateAndTimePicker.setOnClickListener {
            Intent(this, DateAndTimeActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnBottomNavigationMenu.setOnClickListener {
            Intent(this, BottomToolBarMenuActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnViewPager.setOnClickListener {
            Intent(this, ViewPager2Activity::class.java).also {
                startActivity(it)
            }
        }
    }
}