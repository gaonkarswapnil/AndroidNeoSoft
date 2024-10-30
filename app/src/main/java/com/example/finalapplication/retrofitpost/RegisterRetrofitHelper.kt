package com.example.finalapplication.retrofitpost

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RegisterRetrofitHelper {
    val BASE_URL = "http://staging.php-dev.in:8844/trainingapp/api"

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}