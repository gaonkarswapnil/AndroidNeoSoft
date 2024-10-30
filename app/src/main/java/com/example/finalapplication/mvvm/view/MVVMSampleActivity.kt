package com.example.finalapplication.mvvm.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityMvvmsampleBinding
import com.example.finalapplication.mvvm.model.Employee
import com.example.finalapplication.mvvm.model.EmployeeDatabase
import com.example.finalapplication.mvvm.model.EmployeeRepository
import com.example.finalapplication.mvvm.viewmodel.EmployeeViewModel
import com.example.finalapplication.mvvm.viewmodel.EmployeeViewModelFactory

class MVVMSampleActivity : AppCompatActivity() {
    lateinit var binding: ActivityMvvmsampleBinding
    lateinit var employeeViewModel: EmployeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmsample)

        val dao = EmployeeDatabase.getInstance(applicationContext).employeeDao()

        val repository = EmployeeRepository(dao)


        employeeViewModel=ViewModelProvider(this, EmployeeViewModelFactory(repository)).get(EmployeeViewModel::class.java);


        employeeViewModel.getEmployeeData().observe(this, Observer{
            binding.employee = it.toString()
        })

        binding.btnAddEmployee.setOnClickListener {
            val employee = Employee(name = "Oliver", designation = "Developer")

            employeeViewModel.insertEmployee(employee)
        }

    }
}