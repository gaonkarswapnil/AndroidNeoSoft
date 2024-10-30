package com.example.finalapplication.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finalapplication.mvvm.model.EmployeeRepository

class EmployeeViewModelFactory(private val employeeRepository: EmployeeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeViewModel(employeeRepository) as T
    }
}