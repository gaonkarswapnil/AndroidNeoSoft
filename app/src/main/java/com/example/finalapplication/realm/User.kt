package com.example.finalapplication.realm

import androidx.room.PrimaryKey
import io.realm.RealmObject
import java.util.UUID

open class User: RealmObject() {
    @PrimaryKey(autoGenerate = true)
    var id: String = UUID.randomUUID().toString()
//    var name: String? = null
    var visitCount: Int = 0
}