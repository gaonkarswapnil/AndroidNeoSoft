package com.example.finalapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapplication.activitylifecycle.ActivityLifeCycleActivity
import com.example.finalapplication.bottomtoolbarmenu.BottomToolBarMenuActivity
import com.example.finalapplication.data.DataActivity
import com.example.finalapplication.databinding.ActivityMainBinding
import com.example.finalapplication.databinding.DataBindingActivity
import com.example.finalapplication.fragment.FragmentActivity
import com.example.finalapplication.fragmentlifecycle.FragmentLifeCycleActivity
import com.example.finalapplication.gson.GSONParsingActivity
import com.example.finalapplication.inkapi.BasicHandwritingRecognizer
import com.example.finalapplication.jsondata.ReadJsonActivity
import com.example.finalapplication.jsondata.displayjson.SimpleJSONFetchActivity
import com.example.finalapplication.jsondata.jsonarray.ReadJSONArrayActivity
import com.example.finalapplication.jsondata.jsondataquiz.QuizJsonActivity
import com.example.finalapplication.layout.gridlayout.GridLayoutActivity
import com.example.finalapplication.livedata.LiveDataActivity
import com.example.finalapplication.logintask.LoginTaskActivity
import com.example.finalapplication.mvparchitecture.presenter.AddPersonPresenter
import com.example.finalapplication.mvparchitecture.view.AddPersonActivity
import com.example.finalapplication.mvvm.view.MVVMSampleActivity
import com.example.finalapplication.onsavedinstancestate.OnSavedInstanceActivity
import com.example.finalapplication.realm.RealmActivity
import com.example.finalapplication.retrofit.RetrofitActivity
import com.example.finalapplication.retrofitpost.RetrofitPostActivity
import com.example.finalapplication.roomdb.DemoRoomDBActivity
import com.example.finalapplication.service.IntentServiceActivity
import com.example.finalapplication.sharedpeferences.SharedPeferencesActivity
import com.example.finalapplication.slidermenu.SliderMenuActivity
import com.example.finalapplication.toolbarmenu.ToolBarMenuActivity
import com.example.finalapplication.twoactivityinteraction.FirstActivityLifeCycleActivity
import com.example.finalapplication.viewmodel.IncrementActivity
import com.example.finalapplication.viewpager2.ViewPager2Activity
import com.example.finalapplication.weatherappgson.WeatherReport
import com.example.finalapplication.weatherappgson.WeatherReportActivity
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

        binding.btnGridLayout.setOnClickListener {
            Intent(this, GridLayoutActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnSliderMenu.setOnClickListener {
            Intent(this, SliderMenuActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnDataSharing.setOnClickListener {
            Intent(this, DataActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnSavePref.setOnClickListener {
            Intent(this, SharedPeferencesActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnJSONFileReader.setOnClickListener {
            Intent(this, ReadJsonActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnJSONArrayReader.setOnClickListener {
            Intent(this, ReadJSONArrayActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnJSONQuizReader.setOnClickListener {
            Intent(this, QuizJsonActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnNestedJSONReader.setOnClickListener {
            Intent(this, SimpleJSONFetchActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnIntentServices.setOnClickListener {
            Intent(this, IntentServiceActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnINKAPI.setOnClickListener {
            Intent(this, BasicHandwritingRecognizer::class.java).also {
                startActivity(it)
            }
        }

        binding.btnUserDatabase.setOnClickListener {
            Intent(this, DemoRoomDBActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnUserLoginDatabaseTask.setOnClickListener {
            Intent(this, LoginTaskActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnMVP.setOnClickListener {
            Intent(this, AddPersonActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnTestRealm.setOnClickListener {
            Intent(this, RealmActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnOnSavedInstance.setOnClickListener {
            Intent(this, OnSavedInstanceActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnGSONParsing.setOnClickListener {
            Intent(this, GSONParsingActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnWeatherReport.setOnClickListener {
            Intent(this, WeatherReportActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnRetroFit.setOnClickListener {
            Intent(this, RetrofitActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnViewModel.setOnClickListener {
            Intent(this, IncrementActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnLiveData.setOnClickListener {
            Intent(this, LiveDataActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnDataBinding.setOnClickListener {
            Intent(this, DataBindingActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnMVVMExample.setOnClickListener {
            Intent(this, MVVMSampleActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}