package com.example.finalapplication.mvvm.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {
    @Query("select * from employee_table")
    fun getEmployeeData(): LiveData<List<Employee>>

    @Insert
    suspend fun insertEmployee(emp: Employee)
}