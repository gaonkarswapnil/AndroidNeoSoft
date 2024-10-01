package com.example.finalapplication.jsondata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityReadJsonBinding
import org.json.JSONObject

class ReadJsonActivity : AppCompatActivity() {
    lateinit var binding: ActivityReadJsonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityReadJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val usersList: MutableList<UserModelClass> = mutableListOf()

        try {
            val obj = JSONObject(getJSONFromAssets()!!)
            val usersArray = obj.getJSONArray("users")

            for(i in 0 until usersArray.length()){
                val user = usersArray.getJSONObject(i);

                val id = user.getInt("id");
                val name = user.getString("name")
                val email = user.getString("email")
                val gender = user.getString("gender")
                val weight = user.getDouble("weight")
                val height = user.getInt("height")

                val phone = user.getJSONObject("phone")
                val mobile = phone.getString("mobile")
                val office = phone.getString("office")

                val userDetail = UserModelClass(id, name, email, gender, weight, height, mobile, office)
                usersList.add(userDetail)
            }
        }catch (e: Exception){
            e.printStackTrace()
        }

        binding.rvUserList.layoutManager = LinearLayoutManager(this)
        val itemAdapter = UserAdapter(usersList)
        binding.rvUserList.adapter = itemAdapter

    }

    private fun getJSONFromAssets(): String? {
        var json: String? = null
        val charset = Charsets.UTF_8

        try {
            val myUserJsonFile = assets.open("Users.json")
            val size = myUserJsonFile.available()
            val buffer = ByteArray(size)

            myUserJsonFile.read(buffer)
            myUserJsonFile.close()

            json = String(buffer, charset)

        }catch (e: Exception){
            e.printStackTrace()
        }

        return json
    }
}