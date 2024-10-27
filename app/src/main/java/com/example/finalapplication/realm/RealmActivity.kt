package com.example.finalapplication.realm

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityRealmBinding
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject

class RealmActivity : AppCompatActivity() {
    lateinit var binding: ActivityRealmBinding
    lateinit var realm: Realm

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRealmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Realm.init(this)
//
//
        val config = RealmConfiguration.Builder()
            .name("test.db")
            .build()

        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()

        Toast.makeText(this, "$realm", Toast.LENGTH_SHORT).show()
//
        realm.executeTransaction {
            val info = User().apply {
                visitCount = count++;
            }

            it.insert(info)
        }


//        val user = getUsers()


        
    }

//    private fun getUsers(): List<User> {
//        return realm.where<User>(User::class.java).findAll()
//    }
//
//    private fun addUser(name: String) {
//        try {
//            realm.executeTransaction { realm ->
//                val user = realm.createObject(User::class.java, System.currentTimeMillis())
//                user.name = name
//            }
//        } catch (e: Exception) {
//            Log.d("RealmActivity", "Error adding user: ${e.message}")
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}