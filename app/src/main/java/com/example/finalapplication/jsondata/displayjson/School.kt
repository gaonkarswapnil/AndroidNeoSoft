package com.example.finalapplication.jsondata.displayjson

data class School(
    val name: String,
    val location: String,
    val students: List<Student>,
    val teachers: List<Teacher>,
    val classes: List<Classes>,
    val extraCurricularActivities: List<ExtraCurricularActivities>
)