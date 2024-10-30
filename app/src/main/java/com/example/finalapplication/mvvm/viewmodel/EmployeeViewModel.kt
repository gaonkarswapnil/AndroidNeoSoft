package com.example.finalapplication.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapplication.mvvm.model.Employee
import com.example.finalapplication.mvvm.model.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(private val employeeRepository: EmployeeRepository): ViewModel() {
    fun getEmployeeData(): LiveData<List<Employee>>{
        return employeeRepository.getEmployeeData()
    }

    fun insertEmployee(emp: Employee){
        viewModelScope.launch(Dispatchers.IO) {
            employeeRepository.insertEmployee(emp)
        }

    }
}