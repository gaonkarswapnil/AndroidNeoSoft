package com.example.finalapplication.jsondata.jsonarray

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityReadJsonarrayBinding
import com.example.finalapplication.jsondata.UserModelClass
import org.json.JSONArray
import org.json.JSONObject

class ReadJSONArrayActivity : AppCompatActivity() {
    lateinit var binding: ActivityReadJsonarrayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityReadJsonarrayBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val userList: MutableList<UserArrayModelClass> = mutableListOf()

        try {
            val obj = JSONArray(getJSONFromAsset()!!)
            for(i in 0 until obj.length()){
                val user: JSONObject = obj.getJSONObject(i)

                val id = user.getInt("id");
                val name = user.getString("name")
                val email = user.getString("email")
                val gender = user.getString("gender")
                val weight = user.getDouble("weight")
                val height = user.getInt("height")

                val phone = user.getJSONObject("phone")
                val mobile = phone.getString("mobile")
                val office = phone.getString("office")

                val userDetail = UserArrayModelClass(id, name, email, gender, weight, height, mobile, office)
                userList.add(userDetail)
            }

        }catch (e: Exception){
            e.printStackTrace()
        }
        binding.rvUserArrayList.layoutManager = LinearLayoutManager(this)
        val itemAdapter = UserArrayAdapter(userList)
        binding.rvUserArrayList.adapter = itemAdapter
    }

    private fun getJSONFromAsset(): String? {
        var json: String? = null
        val charset = Charsets.UTF_8

        try {
            val myUserJsonFile = assets.open("UsersArray.json")
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