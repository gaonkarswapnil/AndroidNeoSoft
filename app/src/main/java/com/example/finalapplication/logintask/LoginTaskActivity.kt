package com.example.finalapplication.logintask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityLoginTaskBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginTaskActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginTaskBinding
    private lateinit var etEmail: String
    private lateinit var etPassword: String

    var list: MutableList<User> = mutableListOf()
    private lateinit var database: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        database = Room.databaseBuilder(this, UserDatabase::class.java, "userDB").build()

//        loadData();
        lifecycleScope.launch {
            loadData()
        }


//        Log.d("Oliver_Database_Login", "${list}")

        binding.btnSignIn.setOnClickListener {
            etEmail = binding.etEmailId.text.toString()
            etPassword = binding.etPassword.text.toString()

            when {
                etEmail.isEmpty() -> binding.etEmailId.error = "Email required"
                etPassword.isEmpty() -> binding.etPassword.error = "Password required"
                else -> handleLogin(etEmail, etPassword)
            }
        }


        binding.tvSignUp.setOnClickListener {
            Intent(this, RegistrationTaskActivity::class.java).also {
                startActivity(it)
            }
        }


    }

    private fun handleLogin(email: String, password: String) {
        val user = list.firstOrNull { it.email == email }

        when {
            user == null -> {
                Log.d("Database_Login", "Email not found: $email")
                Toast.makeText(this, "Email not found", Toast.LENGTH_SHORT).show()
            }
            user.password.equals(password) -> {
                Log.d("Database_Login", "Login successful for user: ${user.firstName}")
                Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show()
                Intent(this, DisplayDataActivity::class.java).apply {
                    putExtra("userID", user.id)
                    startActivity(this)
                }
                binding.etEmailId.setText("");
                binding.etPassword.setText("")
            }
            else -> {
                Log.d("Database_Login", "Incorrect password for user: $email")
                Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun loadData() {
        list.clear()
        list.addAll(database.userDao().getUserData())
        Log.d("Oliver_Database_Login", list.toString())
    }
}