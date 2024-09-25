package com.example.finalapplication.toolbarmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityToolBarMenuBinding

class ToolBarMenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityToolBarMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityToolBarMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContact -> Toast.makeText(this, "Add to Contact", Toast.LENGTH_SHORT).show()
            R.id.miFavorite -> Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this, "Feedback", Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()
        }
        return true
    }
}