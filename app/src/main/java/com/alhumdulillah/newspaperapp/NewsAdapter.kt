package com.alhumdulillah.newspaperapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val items: ArrayList<String>, private val listener : NewsItemClick): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)

        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener(){
            listener.onItemClick(items[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       val currentItems = items[position]
        holder.titleView1.text = currentItems
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
class NewsViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    val titleView1: TextView = itemView.findViewById(R.id.title)
}

interface NewsItemClick{
    fun onItemClick(item: String)
}