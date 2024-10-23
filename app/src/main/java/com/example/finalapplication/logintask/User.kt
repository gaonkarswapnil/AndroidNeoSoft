package com.example.finalapplication.logintask

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.ParcelField
import java.io.Serializable

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var firstName: String,
    var lastName: String,
    var email: String,
    var password: String,
    var imageData: ByteArray?
): Serializable

