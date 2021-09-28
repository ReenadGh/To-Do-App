package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter (private val items: ArrayList<ToDoitems> ): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>(){
    class ItemViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val task =  items[position].task
        val isChecked = items[position].Checked

        holder.itemView.apply {

            task1.text= task
            checkBox1.isChecked = isChecked




        }
    }



    override fun getItemCount() = items.size

    fun deleteItems(){
        items.removeAt(0)
        notifyDataSetChanged()
    }

}
