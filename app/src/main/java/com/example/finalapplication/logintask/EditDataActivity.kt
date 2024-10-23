package com.example.finalapplication.logintask

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.finalapplication.databinding.ActivityEditDataBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import com.example.finalapplication.R

class EditDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditDataBinding
    private lateinit var database: UserDatabase

    private var userClass: User? = null
    private var selectedImage: ByteArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fetching userID from the intent
        val userId = intent.getLongExtra("User_ID", -1)

        // Initialize database
        database = Room.databaseBuilder(this, UserDatabase::class.java, "userDB").build()

        // Load user data
        lifecycleScope.launch {
            loadUserData(userId)
        }

        // Handle image picker (if needed)
        binding.ivProfileImage.setOnClickListener {
            pickImageFromGallery()
        }

        // Update user data
        binding.btnUpdateData.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmailId.text.toString()

            if (userClass != null) {
                userClass = User(
                    userClass!!.id,
                    firstName,
                    lastName,
                    email,
                    userClass!!.password,
                    selectedImage ?: userClass!!.imageData // Keep old image if not changed
                )

                lifecycleScope.launch {
                    updateUserInDatabase(userClass!!)
                }
            }
        }
    }

    private suspend fun loadUserData(userId: Long) {
        withContext(Dispatchers.IO) {
            userClass = database.userDao().getUserById(userId)
            withContext(Dispatchers.Main) {
                userClass?.let {
                    binding.etFirstName.setText(it.firstName)
                    binding.etLastName.setText(it.lastName)
                    binding.etEmailId.setText(it.email)
                    it.imageData?.let { imageBytes ->
                        binding.ivProfileImage.setImageBitmap(byteArrayToBitmap(imageBytes))
                    }
                } ?: run {
                    Toast.makeText(this@EditDataActivity, "User not found", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

    private suspend fun updateUserInDatabase(user: User) {
        withContext(Dispatchers.IO) {
            database.userDao().updateUser(user)
            withContext(Dispatchers.Main) {
                setResult(Activity.RESULT_OK, intent.putExtra("updatedUserData", user))
                Toast.makeText(applicationContext, "Successfully updated data", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    // Declare the launcher as a class-level property
    private val imagePickerLauncher = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                binding.ivProfileImage.setImageBitmap(bitmap)
                selectedImage = bitmapToByteArray(bitmap)
            } catch (e: Exception) {
                Log.e("EditDataActivity", "Error loading image: ${e.message}")
                Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.d("EditDataActivity", "No media selected")
        }
    }

    // Function to launch the picker
    private fun pickImageFromGallery() {
        // Launch the image picker
       // imagePickerLauncher.launch(ActivityResultContracts.PickVisualMedia.ImageOnly)
    }


    private fun byteArrayToBitmap(it: ByteArray): Bitmap? {
        return BitmapFactory.decodeByteArray(it, 0, it.size)
    }

    private fun bitmapToByteArray(bitmap: Bitmap?): ByteArray? {
        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }
}
