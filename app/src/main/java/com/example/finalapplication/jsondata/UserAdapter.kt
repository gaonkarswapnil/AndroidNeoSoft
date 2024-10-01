package com.example.finalapplication.jsondata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.R

class UserAdapter(val items: List<UserModelClass>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.itemView.also {
            it.findViewById<TextView>(R.id.tv_id).text = item.id.toString()
            it.findViewById<TextView>(R.id.tv_name).text = item.name
            it.findViewById<TextView>(R.id.tv_email).text = item.email
            it.findViewById<TextView>(R.id.tv_gender).text = item.gender
            it.findViewById<TextView>(R.id.tv_weight).text = item.weight.toString()
            it.findViewById<TextView>(R.id.tv_height).text = item.height.toString()
            it.findViewById<TextView>(R.id.tv_mobile).text = item.mobile
            it.findViewById<TextView>(R.id.tv_office_number).text = item.office
        }
    }
}