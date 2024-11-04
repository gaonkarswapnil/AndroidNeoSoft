package com.example.finalapplication.retrofitmvvm.view

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityRegistrationBinding
import com.example.finalapplication.retrofitmvvm.model.RegistrationRequest
import com.example.finalapplication.retrofitmvvm.repository.UserRepository
import com.example.finalapplication.retrofitmvvm.viewmodel.UserViewModel
import com.example.finalapplication.retrofitmvvm.viewmodel.UserViewModelFactory

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(application, UserRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnRegisterPage.setOnClickListener {

            val gender = when(binding.rgGender.checkedRadioButtonId){
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                else -> {}
            }

            val request = RegistrationRequest(
                binding.etFirstName.text.toString(),
                binding.etLastName.text.toString(),
                binding.etEmail.text.toString(),
                binding.etPasswordMvvm.text.toString(),
                binding.etConfirmPasswordMvvm.text.toString(),
                gender.toString(),
                binding.etPhoneNo.text.toString().toLong()
            )

            userViewModel.createUser(request).observe(this, Observer {
                if(it.status == 200){
                    Log.d("Retrofit_User_RegistrationActivity", "${it.message} ${it.user_msg}")
                }
                else{
                    Log.d("Retrofit_User_RegistrationActivity", "${it.status} ${it.message} ${it.user_msg}")
                }
            })

        }

    }
}