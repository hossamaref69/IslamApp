package com.example.islamapp.screens.home.fragments.ahadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamapp.model.HadeethModel
import com.example.islamapp.R


class AhadethAdapter(val ahadeth:ArrayList<HadeethModel>) : RecyclerView.Adapter<AhadethAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val hadethNameTv = itemView.findViewById<TextView>(R.id.itemSuraNameTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = ahadeth[position].title
        holder.hadethNameTv.text = title

        if (onHadethClick != null){
            holder.itemView.setOnClickListener{
                onHadethClick!!.onItemClick(ahadeth[position],position)
            }
        }

    }

    override fun getItemCount(): Int {
        return ahadeth.size
    }

    interface OnItemClickListener{
        fun onItemClick (hadeth: HadeethModel, index: Int)
    }

    var onHadethClick: OnItemClickListener? = null
}