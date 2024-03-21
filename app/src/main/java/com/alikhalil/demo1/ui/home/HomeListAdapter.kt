package com.alikhalil.demo1.ui.home

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alikhalil.demo1.R

class HomeListAdapter(val dataList: List<String>) :
    RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val testText: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = View.inflate(parent.context, R.layout.home_list_item, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.testText.text = dataList[position]
    }
}