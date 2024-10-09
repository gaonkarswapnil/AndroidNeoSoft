package com.example.finalapplication.jsondata.jsondataquiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityQuizJsonBinding
import org.json.JSONArray
import org.json.JSONObject
import java.util.ArrayList

class QuizJsonActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuizJsonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityQuizJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val questionsList: MutableList<Quiz> = mutableListOf();
        try {
            val obj = JSONArray(getJSONFromAsset()!!)
            for (i in 0 until obj.length()) {
                val quiz: JSONObject = obj.getJSONObject(i)
                val question = quiz.getString("question")
                val options = quiz.getJSONArray("options")
                val optionList: MutableList<String> = mutableListOf()
                for (i in 0 until options.length()) {
                    optionList.add(options[i].toString())
                }
                val answer = quiz.getString("answer")

                val quizModel: Quiz = Quiz(question, optionList, answer)
                questionsList.add(quizModel)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        binding.rvQuestionsList.layoutManager = LinearLayoutManager(this)
        val itemAdapter = QuizAdapter(questionsList)

        binding.rvQuestionsList.adapter = itemAdapter


        binding.btnSendListData.setOnClickListener {
            Toast.makeText(this, "${itemAdapter.viewSelectedAnswers()}", Toast.LENGTH_SHORT).show()
            Log.d("Oliver Main Activity", "${itemAdapter.viewSelectedAnswers()}")

            Intent(this, FetchRecyclerViewData::class.java).also {
                it.putParcelableArrayListExtra("selectedItem", ArrayList(itemAdapter.viewSelectedAnswers()))
                startActivity(it)
            }
        }
    }

    private fun getJSONFromAsset(): String? {
        var json: String? = null;
        val charset = Charsets.UTF_8

        try {
            val myQuestionJSONFile = assets.open("QuizData.json")
            val size = myQuestionJSONFile.available()
            val buffer = ByteArray(size)

            myQuestionJSONFile.read(buffer)
            myQuestionJSONFile.close()
            json = String(buffer, charset)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return json
    }
}