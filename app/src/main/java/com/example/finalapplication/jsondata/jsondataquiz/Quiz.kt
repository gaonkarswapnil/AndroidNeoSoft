package com.example.finalapplication.jsondata.jsondataquiz

data class Quiz(
    val question: String,
    val options :List<String>,
    val correctOption: String
)