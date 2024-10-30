package com.example.finalapplication.viewmodelusinggson

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class UserArrayViewModel(val context: Context):ViewModel() {
    lateinit var userList: Array<User>
    private var index = 0
    init {
        loadData()
    }

    private fun loadData() {
        val gson = Gson()
    }
}