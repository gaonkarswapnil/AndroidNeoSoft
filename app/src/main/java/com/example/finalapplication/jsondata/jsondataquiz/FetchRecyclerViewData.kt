package com.example.finalapplication.jsondata.jsondataquiz

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapplication.databinding.ActivityFetchRecyclerViewDataBinding

class FetchRecyclerViewData : AppCompatActivity() {
    lateinit var binding: ActivityFetchRecyclerViewDataBinding
    var score = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFetchRecyclerViewDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var question = 1;
        val selectedAnswer = intent.getParcelableArrayListExtra<QuizData>("selectedItem")
        val result= StringBuilder();
        selectedAnswer?.forEach {
            result.append("\n${question++}: \t");
            result.append("${it.optionSelected} \t")
            result.append(" isCorrect: ${
                if(it.isCorrect){
                    score++;
                    "Yes"
                }else{
                    "No"
                }
            }")
        }
        binding.tvSetData.text = result.toString()

        val alert = AlertDialog.Builder(this)
            .setTitle("Score")
            .setMessage("Your score is ${score}")
            .setPositiveButton("OK"){ _, _ ->

            }
            .setNegativeButton("Back to Quiz"){ _, _ ->
                finish()
            }.create()
        binding.btnCheckScore.setOnClickListener {

            alert.show()
        }
    }
}