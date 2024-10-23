package com.example.finalapplication.mvparchitecture.model

class PersonModel(private val personDao: PersonDao) {
    suspend fun addPerson(name: String, age: Int){
        personDao.addPerson(Person(name = name, age = age));
    }

    suspend fun getPersons(): List<Person>{
        return personDao.getPersonData()
    }
}