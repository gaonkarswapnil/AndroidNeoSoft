package com.example.finalapplication.mvparchitecture.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityAddPersonBinding
import com.example.finalapplication.mvparchitecture.model.PersonDatabase
import com.example.finalapplication.mvparchitecture.model.PersonModel
import com.example.finalapplication.mvparchitecture.presenter.AddPersonPresenter

class AddPersonActivity : AppCompatActivity(), AddPersonView {
    lateinit var binding: ActivityAddPersonBinding
    lateinit var persentor: AddPersonPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Room.databaseBuilder(applicationContext, PersonDatabase::class.java, "personDB").build()
        persentor = AddPersonPresenter(this, PersonModel(database.personDao()))


        binding.btnAdd.setOnClickListener {
            val name =binding.etAddPersonName.text.toString()
            val age = binding.etAddPersonAge.text.toString().toInt()
            persentor.addPerson(name, age)
        }

        binding.btnShow.setOnClickListener {
//            Toast.makeText(this, "Next Activity", Toast.LENGTH_SHORT).show()
            Intent(this, DisplayPersonActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    override fun showSuccessMessage() {
        Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show()
    }
}