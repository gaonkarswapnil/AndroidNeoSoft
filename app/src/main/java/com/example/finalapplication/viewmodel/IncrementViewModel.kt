package com.example.finalapplication.viewmodel

import androidx.lifecycle.ViewModel

class IncrementViewModel(var initialValue: Int): ViewModel() {

    var count: Int = initialValue

    fun increment(){
        count++
    }

}