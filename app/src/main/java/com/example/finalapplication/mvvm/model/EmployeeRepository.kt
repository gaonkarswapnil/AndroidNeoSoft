package com.example.finalapplication.mvvm.model

import androidx.lifecycle.LiveData

class EmployeeRepository(private val dao: EmployeeDao) {

    fun getEmployeeData(): LiveData<List<Employee>>{
        return dao.getEmployeeData()
    }

    suspend fun insertEmployee(emp: Employee){
        dao.insertEmployee(emp)
    }
}