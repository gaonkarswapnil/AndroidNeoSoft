package com.example.finalapplication.mvparchitecture.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.R
import com.example.finalapplication.jsondata.UserAdapter
import com.example.finalapplication.mvparchitecture.model.Person
import kotlin.math.truncate

class PersonAdapter(private var persons: List<Person>): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_data, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.itemView.also {
            it.findViewById<TextView>(R.id.tvPersonName).text = persons[position].name;
            it.findViewById<TextView>(R.id.tvPersonAge).text = persons[position].age.toString()
        }
    }

}