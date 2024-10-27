package com.example.finalapplication.mvparchitecture.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
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
    var personList: List<Person> = listOf();
    lateinit var adapter: PersonAdapter

    private lateinit var presenter: DisplayPersonPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDisplayPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database =
            Room.databaseBuilder(applicationContext, PersonDatabase::class.java, "personDB").build()

        presenter = DisplayPersonPresenter(this, PersonModel(database.personDao()))

        presenter.loadPersons()
//        val adapter = PersonAdapter(database.personDao().getPersonData())
//        binding.rvPersonData.adapter = adapter
        binding.rvPersonData.layoutManager = LinearLayoutManager(this)

        binding.svSearch.also {
            it.clearFocus()
            it.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
//                    if (personList.any {it.name.equals(query)}) {
                    adapter.filter(query?:"")
//                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.filter(newText?:"")
                    return true
                }

            })
        }


        binding.btnBack.setOnClickListener {
            finish()
        }

    }

    override fun displayPerson(persons: List<Person>) {
        personList = persons.toMutableList()
        adapter = PersonAdapter(persons)
        binding.rvPersonData.adapter = adapter
    }

}