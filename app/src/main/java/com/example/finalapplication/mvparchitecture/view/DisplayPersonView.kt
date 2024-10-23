package com.example.finalapplication.mvparchitecture.view

import com.example.finalapplication.mvparchitecture.model.Person

interface DisplayPersonView {
    fun displayPerson(persons: List<Person>)
}