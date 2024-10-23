package com.example.finalapplication.logintask

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.MediaStore
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityRegistrationTaskBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream

class RegistrationTaskActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationTaskBinding
    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var email: String
    lateinit var password: String
    lateinit var rePassword: String
    private var selectedImage: ByteArray? =null

    private lateinit var database: UserDatabase

    private val imagePickerLauncher = registerForActivityResult(
//        ActivityResultContracts.GetContent()
        ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        uri?.let {
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, it)
            binding.ivProfileImage.setImageBitmap(bitmap)
            selectedImage = bitmapToByteArray(bitmap)
        }

        if (uri != null) {
            Log.d("PhotoPicker", "Selected URI: $uri")
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegistrationTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        database = Room.databaseBuilder(this, UserDatabase::class.java, "userDB").build()

        binding.tvSignIn.setOnClickListener {
            Intent(this, LoginTaskActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnSelectImage.setOnClickListener {
            imagePickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.SingleMimeType("image/jpeg")))
        }

        binding.btnSignUp.setOnClickListener {
            uploadData();
        }

    }

    private fun uploadData() {
        firstName = binding.etFirstName.text.toString()
        lastName = binding.etLastName.text.toString()
        email = binding.etEmailId.text.toString()
        password = binding.etPassword.text.toString()
        rePassword = binding.etConfirmPassword.text.toString()

        when{
            firstName.isEmpty() ->  binding.etFirstName.error = "First Name Required"
            lastName.isEmpty() -> binding.etLastName.error = "Last Name Required"
            email.isEmpty() -> binding.etEmailId.error = "Email Required"
            password.isEmpty() -> binding.etPassword.error = "Password Required"
            rePassword.isEmpty() -> binding.etConfirmPassword.error = "Confirm Password Required"
            !(password.equals(rePassword)) -> binding.etConfirmPassword.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_light))
            else -> {
                binding.etConfirmPassword.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
                Toast.makeText(this, "Successfully Register", Toast.LENGTH_SHORT).show()
                val user = User(0, firstName, lastName, email, password, selectedImage)
                Log.d("Oliver_Database", user.toString())
                lifecycleScope.launch {
                    database.userDao().insertUser(user)
                }
                finish()
            }
        }

    }

    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }

}