package com.example.finalapplication.widgets.customdialog

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityCustomDialogBinding

class CustomDialogActivity : AppCompatActivity() {
    lateinit var binding: ActivityCustomDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCustomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog_ui, null)
        val newCustomDialog =AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        val btnYes = dialogView.findViewById<Button>(R.id.btnYes)
        val btnNo = dialogView.findViewById<Button>(R.id.btnNo)
        binding.btnCustomAlertDialog.setOnClickListener {
            newCustomDialog.show()
        }

        btnYes.setOnClickListener {
            finish()
        }
        btnNo.setOnClickListener {
            newCustomDialog.dismiss()
        }
        
    }
}