package com.example.finalapplication.livedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LiveDataViewModelFactory(val str: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LiveDataViewModel() as T
    }
}