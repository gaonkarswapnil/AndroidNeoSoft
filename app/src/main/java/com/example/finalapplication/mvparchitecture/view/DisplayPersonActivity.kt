package com.example.finalapplication.mvparchitecture.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityDisplayDataBinding
import com.example.finalapplication.databinding.ActivityDisplayPersonBinding
import com.example.finalapplication.mvparchitecture.model.Person
import com.example.finalapplication.mvparchitecture.model.PersonDatabase
import com.example.finalapplication.mvparchitecture.model.PersonModel
import com.example.finalapplication.mvparchitecture.presenter.DisplayPersonPresenter

class DisplayPersonActivity : AppCompatActivity(), DisplayPersonView {
    lateinit var binding: ActivityDisplayPersonBinding
    var personList: MutableList<Person> = mutableListOf();

    private lateinit var presenter: DisplayPersonPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDisplayPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Room.databaseBuilder(applicationContext, PersonDatabase::class.java, "personDB").build()

        presenter = DisplayPersonPresenter(this, PersonModel(database.personDao()))

//        personList= presenter.loadPersons()
        val adapter = PersonAdapter(database.personDao().getPersonData())
        binding.rvPersonData.adapter = adapter
        binding.rvPersonData.layoutManager = LinearLayoutManager(this)

    }

    override fun displayPerson(persons: List<Person>) {
        TODO("Not yet implemented")
    }
}