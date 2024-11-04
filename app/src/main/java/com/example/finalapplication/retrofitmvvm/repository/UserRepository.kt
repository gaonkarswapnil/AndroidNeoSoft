package com.example.finalapplication.retrofitmvvm.repository

import android.util.Log
import com.example.finalapplication.retrofitmvvm.model.ApiService
import com.example.finalapplication.retrofitmvvm.model.ApiServiceBuilder
import com.example.finalapplication.retrofitmvvm.model.RegistrationRequest
import kotlinx.coroutines.flow.flow

class UserRepository {

    val apiService = ApiServiceBuilder.getApiServices();

    fun createUser(registrationRequest: RegistrationRequest) = flow {
        val response = apiService.createUser(registrationRequest.first_name, registrationRequest.last_name, registrationRequest.email, registrationRequest.password, registrationRequest.confirm_password, registrationRequest.gender, registrationRequest.phone_no)

        if(response.isSuccessful && response!=null){
            emit(response.body())
        }else{
            Log.d("Retrofit_User_Repository", response.toString())
        }
    }
}