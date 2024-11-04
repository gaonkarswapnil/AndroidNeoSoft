package com.example.finalapplication.retrofitmvvm.model

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("users/register")
    suspend fun createUser(
        @Field("first_name") first_name: String,
        @Field("last_name") last_name:String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirm_password") confirm_password: String,
        @Field("gender") gender:String,
        @Field("phone_no") phone_no:Long
    ): Response<RegistrationResponse>
}