package com.example.finalapplication.retrofitmvvm.model

data class RegistrationResponse(
    val `data`: List<User>,
    val message: String,
    val status: Int,
    val user_msg: String
)