package com.example.finalapplication.roomdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.R

class ContactAdapter(private val contacts: List<Contact>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    inner class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.itemView.findViewById<TextView>(R.id.etContactName).text = contact.name
        holder.itemView.findViewById<TextView>(R.id.etContactNumber).text = contact.mobile

    }


}