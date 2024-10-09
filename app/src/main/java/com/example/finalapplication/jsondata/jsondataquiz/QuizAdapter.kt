package com.example.finalapplication.jsondata.jsondataquiz

import android.graphics.Color
import android.media.tv.TvContract.Channels.Logo
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.R

class QuizAdapter(val items: MutableList<Quiz>) : RecyclerView.Adapter<QuizAdapter.ViewHolder>() {
    private var selectedAnswers: MutableList<QuizData> = mutableListOf()
    private var selectedPositions: MutableList<Int?> = MutableList(items.size) { null } // Track selected positions

    var isCorrect: Boolean = false
    lateinit var selectedRadioButton: String
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val question = view.findViewById<TextView>(R.id.tvQuestionJSON)
        val radioGroup = view.findViewById<RadioGroup>(R.id.rgOptionsJSON)
        val answer = view.findViewById<TextView>(R.id.tvCorrectAnswer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quiz_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.question.text = item.question
        holder.radioGroup.removeAllViews()

//        holder.radioGroup.apply {
            item.options.forEachIndexed { index, option ->
                val radioButton = RadioButton(holder.radioGroup.context).apply {
                    text = option
                    id = View.generateViewId()

                    if(selectedPositions[position] == index){
                        isChecked = true;
                    }
                }
                holder.radioGroup.addView(radioButton)
//                radioButton.tag = index
            }

            holder.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val selectedRadioButton = group.findViewById<RadioButton>(checkedId)
                selectedRadioButton?.let {
                    val selectedIndex = group.indexOfChild(it);
                    selectedPositions[position] = selectedIndex

                    isCorrect = it.text == item.correctOption

                    val quizData = QuizData(item.question, it.text.toString(), isCorrect)
                    if(selectedAnswers.size > position){
                        selectedAnswers[position] = quizData
                    }else{
                        selectedAnswers.add(quizData)
                    }

                }

//                selectedAnswers.add(selectedRadioButton)
                holder.answer.text = ""
//                holder.answer.apply {
//                    text = if(isCorrect){
//                        setTextColor(Color.GREEN)
//                        "Correct Answer"
//                    }else{
//                       setTextColor(Color.RED)
//                        "InCorrect Answer: ${item.correctOption}"
//                    }
//                }


//                Log.d("Oliver Inside onBind() Temp", quizData.toString())
                Log.d("Oliver Inside OnBind() ", selectedAnswers.toString())
            }

//        }
    }

    fun viewSelectedAnswers(): List<QuizData?>{
        Log.d("Oliver ", selectedAnswers.toString())
        return selectedAnswers
    }
}