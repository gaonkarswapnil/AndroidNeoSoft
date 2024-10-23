package com.example.finalapplication.jsondata.displayjson

data class ExtraCurricularActivities (
    val name: String,
    val coach: String,
    val schedule: List<Schedule>
)