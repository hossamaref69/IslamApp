package com.example.islamapp.screens.home.fragments.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamapp.R

class SuraNameAdapter(private val suraNames:Array<String>) : RecyclerView.Adapter<SuraNameAdapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val suraNameTv = itemView.findViewById<TextView>(R.id.itemSuraNameTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return suraNames.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraNames = suraNames[position]
        holder.suraNameTv.text = suraNames

        if (onSuraClick != null){
            holder.itemView.setOnClickListener{
                onSuraClick!!.onItemClick(suraNames,position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick (suraName: String, index: Int)
    }

    var onSuraClick: OnItemClickListener? = null
}