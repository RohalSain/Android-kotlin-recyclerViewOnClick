package com.developer.rohal.onclickrecyclerview

import android.R.attr.name
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.util.Log
import java.nio.file.Files.size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.items_side_menu_reflection.view.*
import java.util.ArrayList
class ContentAdapter(var userlist: ArrayList<User>, val listener: OnItemClickListener) : RecyclerView.Adapter<ContentAdapter.ViewHolder>()
{
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.items_side_menu_reflection, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = userlist[position]
        holder?.Quote?.text = user.date
        holder.Layout.setOnClickListener {
            listener.onItemClick(position)
        }

        //holder.bind(position, listener)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var QuoteImage = itemView.QuoteImage
        var Quote = itemView.Quote
        var Layout=itemView.wrapLayout
        fun bind(position: Int, listener: OnItemClickListener) {
            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    Log.d("item","yes")
                    listener.onItemClick(adapterPosition)
                }
            })
        }
    }
}