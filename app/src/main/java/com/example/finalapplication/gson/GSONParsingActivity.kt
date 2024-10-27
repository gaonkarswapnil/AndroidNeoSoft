package com.example.finalapplication.gson

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityGsonparsingBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GSONParsingActivity : AppCompatActivity() {
    lateinit var binding: ActivityGsonparsingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGsonparsingBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//        var employee: Employee? = gson.fromJson(getJSONFromAssets(), Employee::class.java)

//        var employees = parseEmployeesFromJson(getJSONFromAssets())

        var gson = Gson()
        var employee: Employee? = gson.fromJson(getJSONFromAssets(), Employee::class.java)
        if (employee != null) {
//            for (employee in employees) {
            Log.d("Oliver GSON Parsing", "First Name: ${employee.firstName}")
            Log.d("Oliver GSON Parsing", "Last Name: ${employee.lastName}")
            for (address in employee.address) {
                Log.d(
                    "Oliver GSON Parsing",
                    "Address: ${address.street}, ${address.city}, ${address.state}"
                )
            }
//            }
        }
    }

    private fun getJSONFromAssets(): String? {
        var json: String? = null
        val charset = Charsets.UTF_8

        try {
            val myUserJsonFile = assets.open("employee.json")
            val size = myUserJsonFile.available()
            val buffer = ByteArray(size)

            myUserJsonFile.read(buffer)
            myUserJsonFile.close()

            json = String(buffer, charset)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return json
    }


//    for JSON ARRAY
//    private fun parseEmployeesFromJson(json: String?): List<Employee>? {
//        return if (json != null) {
//            val gson = Gson()
//            // Use TypeToken to specify that we want a List of Employee
//            val employeeListType = object : TypeToken<List<Employee>>() {}.type
//            gson.fromJson(json, employeeListType)
//        } else {
//            null
//        }
//    }
}