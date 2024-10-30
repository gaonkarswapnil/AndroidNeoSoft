package com.example.finalapplication.mvvm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase: RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao

    companion object{
        var INSTANCE: EmployeeDatabase? = null

        fun getInstance(context: Context): EmployeeDatabase{

            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeDatabase::class.java,
                    "employee_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}