package com.example.finalapplication.widgets.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        var  todoList = mutableListOf(
            Todo("Oliver", false),
            Todo("Swapnil", true),
            Todo("Author", false)
        )

        val adapter = TodoAdapter(todoList)

        binding.rcToDos.adapter = adapter
        binding.rcToDos.layoutManager = LinearLayoutManager(this)


        binding.btnAddTodo.setOnClickListener {
            val title = binding.edToDo.text.toString()

            val todo = Todo(title, false)
            todoList.add(todo)
            binding.edToDo.setText("")
//            adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size-1)

        }
    }
}