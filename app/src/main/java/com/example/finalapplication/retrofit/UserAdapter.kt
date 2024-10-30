package com.example.finalapplication.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.R
import com.example.finalapplication.widgets.recyclerview.Todo

class UserAdapter(var todos: List<UsersItem>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_of_data, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.also {
            it.findViewById<TextView>(R.id.tvUserId).text = todos[position].id.toString()
            it.findViewById<TextView>(R.id.tvUserTitle).text = todos[position].title

            it.findViewById<CheckBox>(R.id.cbIsChecked).isChecked = todos[position].completed
        }
    }
}