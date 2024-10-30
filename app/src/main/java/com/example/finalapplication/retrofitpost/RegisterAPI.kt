package com.example.finalapplication.retrofitpost

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterAPI {

    @POST("/users/register")
    suspend fun createRegistration(@Body register: Register): Response<Register>
}