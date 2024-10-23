package com.example.finalapplication.mvparchitecture.presenter

import com.example.finalapplication.mvparchitecture.model.PersonModel
import com.example.finalapplication.mvparchitecture.view.DisplayPersonView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DisplayPersonPresenter(private val view: DisplayPersonView, private val person: PersonModel) {
    fun loadPersons(){
        CoroutineScope(Dispatchers.IO).launch {
            val persons = person.getPersons()
            withContext(Dispatchers.Main){
                view.displayPerson(persons)
            }
        }
    }
}