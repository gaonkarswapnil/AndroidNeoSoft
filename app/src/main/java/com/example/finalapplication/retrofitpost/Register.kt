package com.example.finalapplication.retrofitpost

data class Register(
    val firstName: String,
    val lastname: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    val gender: String,
    val phone: Long
)