package com.example.finalapplication.mvparchitecture.presenter

import com.example.finalapplication.mvparchitecture.model.Person
import com.example.finalapplication.mvparchitecture.model.PersonModel
import com.example.finalapplication.mvparchitecture.view.AddPersonView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddPersonPresenter(private val view: AddPersonView, private val person: PersonModel) {
    fun addPerson(name: String, age: Int){
        view.showSuccessMessage()
        CoroutineScope(Dispatchers.IO).launch {
            person.addPerson(name, age)
        }
    }
}