package com.example.finalapplication.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel(): ViewModel() {


    private var factDataTextObject = MutableLiveData<String>("This is Live Data")

    val factDataText: LiveData<String>
        get() = factDataTextObject

    fun updateText(str: String){
        factDataTextObject.value = str
    }

}