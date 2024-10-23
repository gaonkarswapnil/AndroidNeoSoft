package com.example.finalapplication.logintask

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.finalapplication.databinding.ActivityDisplayDataBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.finalapplication.R

class DisplayDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayDataBinding
    private lateinit var database: UserDatabase
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the database
        database = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "userDB").build()


    }

    override fun onResume() {
        super.onResume()
        // Fetch the userID passed from the intent
        val userId = intent.getLongExtra("userID", -1)

        // Load user data
        lifecycleScope.launch {
            loadUserData(userId)
        }

        // Handle edit button click
        binding.fbEdit.setOnClickListener {
            val editIntent = Intent(this, EditDataActivity::class.java).apply {
                putExtra("User_ID", userId)
            }
            startActivity(editIntent)
        }

        // Setup custom delete dialog
        setupDeleteDialog()
    }

    private fun setupDeleteDialog() {
        val dialogView = layoutInflater.inflate(R.layout.custom_delete_ui, null)
        val newCustomDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        val btnYes = dialogView.findViewById<Button>(R.id.btnYes)
        val btnNo = dialogView.findViewById<Button>(R.id.btnNo)

        binding.fbDelete.setOnClickListener {
            newCustomDialog.show()
        }

        btnYes.setOnClickListener {
            lifecycleScope.launch {
                deleteUser()
                newCustomDialog.dismiss()
                finish()
            }
        }

        btnNo.setOnClickListener {
            newCustomDialog.dismiss()
        }
    }

    private suspend fun loadUserData(userId: Long) {
        withContext(Dispatchers.IO) {
            try {
                user = database.userDao().getUserById(userId) ?: throw Exception("User not found")
                withContext(Dispatchers.Main) {
                    displayUserData()
                }
            } catch (e: Exception) {
                Log.e("DisplayDataActivity", "Error loading user data: ${e.message}")
            }
        }
    }

    private fun displayUserData() {
        binding.tvFirstName.text = user.firstName
        binding.tvLastName.text = user.lastName
        binding.tvEmail.text = user.email

        user.imageData?.let {
            binding.ivFetchData.setImageBitmap(byteArrayToBitmap(it))
        }

        Log.d("DisplayDataActivity", "Displayed data for user: ${user.firstName}")
    }

    private fun byteArrayToBitmap(it: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(it, 0, it.size)
    }

    private suspend fun deleteUser() {
        withContext(Dispatchers.IO) {
            database.userDao().deleteUser(user)
        }
        Toast.makeText(this, "User deleted", Toast.LENGTH_SHORT).show()
    }
}
