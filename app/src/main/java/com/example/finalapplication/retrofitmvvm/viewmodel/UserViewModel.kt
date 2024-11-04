package com.example.finalapplication.retrofitmvvm.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapplication.retrofitmvvm.model.RegistrationRequest
import com.example.finalapplication.retrofitmvvm.model.RegistrationResponse
import com.example.finalapplication.retrofitmvvm.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(val application: Application, private val userRepository: UserRepository): ViewModel() {

    fun createUser(registrationRequest: RegistrationRequest): LiveData<RegistrationResponse>{
        val registrationResponse = MutableLiveData<RegistrationResponse>()

        viewModelScope.launch {
            userRepository.createUser(registrationRequest).collect{
                registrationResponse.value = it
            }
        }
        return registrationResponse
    }

}