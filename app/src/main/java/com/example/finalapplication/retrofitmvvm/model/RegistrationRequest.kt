package com.example.finalapplication.retrofitmvvm.model

data class RegistrationRequest (
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val confirm_password: String,
    val gender: String,
    val phone_no: Long
)