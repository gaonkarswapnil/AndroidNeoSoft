package com.example.finalapplication.mvparchitecture.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Insert
    fun addPerson(person: Person)

    @Query("select * from person")
    fun getPersonData(): List<Person>

}