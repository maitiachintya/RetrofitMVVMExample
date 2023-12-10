package com.example.simpleretrofitmvvmexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleretrofitmvvmexample.R
import com.example.simpleretrofitmvvmexample.model.ShowAPIModelItem

class ShowActivityAdapter(private val itemList: List<ShowAPIModelItem>)
    : RecyclerView.Adapter<ShowActivityAdapter.ShowViewHolder>(){
    class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewUserData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ShowViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.nameTextView.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}