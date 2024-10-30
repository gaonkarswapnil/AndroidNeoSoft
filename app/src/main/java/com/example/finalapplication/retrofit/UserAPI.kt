package com.example.finalapplication.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface UserAPI {

    @GET("/todos")
    suspend fun getUsers(): Response<List<UsersItem>>

    @GET("/todos/{id}")
    suspend fun getSingleUser(@Path("id") id: Int): Response<UsersItem>

    @POST("/todos")
    suspend fun createUsers(@Body user: UsersItem): Response<UsersItem>

    @PUT("/todos/{id}")
    suspend fun editUsers(@Path("id") id: Int, @Body user: UsersItem): Response<UsersItem>
}