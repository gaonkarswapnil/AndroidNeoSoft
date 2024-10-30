package com.example.finalapplication.retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityRetrofitBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log
import kotlin.math.sin

class RetrofitActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userAPI = RetrofitHelper.getInstance().create(UserAPI::class.java)


//        Log.d("RetroFit OLiver", userAPI.toString())





        lifecycleScope.launch {
            val newUser = UsersItem(true, 201, "Swapnil", 2)

            val createUser = userAPI.createUsers(newUser)
            Log.d("Retrofit Oliver post", createUser.body().toString())
        }



        lifecycleScope.launch {
            val singleUser = userAPI.getSingleUser(200)
            Log.d("Retrofit Oliver Single user", singleUser.body().toString())
        }
        lifecycleScope.launch {
            val modifiedUser = UsersItem(false, 1, "Oliver", 1)

            val updateUser = userAPI.editUsers(1, modifiedUser)
            Log.d("Retrofit Oliver Put", updateUser.body().toString())
        }


        lifecycleScope.launch {
            val result = userAPI.getUsers()

            val adapter = UserAdapter(result.body()!!.toList())

            binding.rvUsers.adapter = adapter;


            Log.d("Retrofit Oliver", result.body().toString())

        }
        binding.rvUsers.layoutManager = LinearLayoutManager(this)




    }
}