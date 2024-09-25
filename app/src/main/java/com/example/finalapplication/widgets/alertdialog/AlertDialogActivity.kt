package com.example.finalapplication.widgets.alertdialog

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlertDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you wanted to add no to contact")
            .setIcon(R.drawable.ic_contact_added)
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("No"){ _, _ ->
                Toast.makeText(this,"Contact not Added", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First Item", "Second Item"," Third Item")
        val singleChoice = AlertDialog.Builder(this)
            .setTitle("Select Any one")
            .setSingleChoiceItems(options, 0){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this,"You clicked ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){ _, _ ->
                Toast.makeText(this," You Accepted the single choice", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Reject"){ _, _ ->
                Toast.makeText(this,"You have Rejected ", Toast.LENGTH_LONG).show()
            }.create()

        binding.btnDialog2.setOnClickListener {
            singleChoice.show()
        }

        val multiChoice = AlertDialog.Builder(this)
            .setTitle("Check Multiple")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)){ dialogInterface: DialogInterface, i: Int, isChecked: Boolean ->
                if(isChecked){
                    Toast.makeText(this, "You Selected ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept"){ _, _ ->
                Toast.makeText(this," You Accepted the Multi choice", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Reject"){ _, _ ->
                Toast.makeText(this,"You have Rejected ", Toast.LENGTH_LONG).show()
            }.create()

        binding.btnDialog3.setOnClickListener {
            multiChoice.show()
        }

        val exit = AlertDialog.Builder(this)
            .setTitle("Close Activity")
            .setIcon(R.drawable.ic_exit_activity)
            .setMessage("Do you want to Exit??")
            .create()

        binding.btnExit.setOnClickListener {
            exit.show()
        }
    }
}