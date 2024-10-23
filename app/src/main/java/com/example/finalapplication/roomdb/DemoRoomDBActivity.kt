package com.example.finalapplication.roomdb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityDemoRoomDbBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DemoRoomDBActivity : AppCompatActivity() {
    lateinit var binding: ActivityDemoRoomDbBinding
    private lateinit var adapter: ContactAdapter
    private var contactsList: MutableList<Contact> = mutableListOf()

    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDemoRoomDbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "contactDB").build()

        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        adapter = ContactAdapter(contactsList)
        binding.rvContacts.adapter = adapter

        GlobalScope.launch {
            loadContact()
        }

        binding.btnAddContact.setOnClickListener {
            GlobalScope.launch {
                database.contactDao().insertContact(Contact(0, binding.etName.text.toString(), binding.etPhone.text.toString()));
                loadContact()
            }
            binding.etName.setText("")
            binding.etPhone.setText("")
            Toast.makeText(this, "Data added", Toast.LENGTH_SHORT).show()
        }


    }

    suspend fun loadContact() {
        contactsList.clear()
        contactsList.addAll(database.contactDao().getContacts())
        runOnUiThread {
            adapter.notifyDataSetChanged()
        }
    }

}