package com.example.finalapplication.jsondata.displayjson

data class Student (
    val studentId: Int,
    val studentName: String,
    val studentGrade: String,
    val subjects: List<Subject>,
)