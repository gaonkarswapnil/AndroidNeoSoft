package com.example.finalapplication.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val mobile: String
)