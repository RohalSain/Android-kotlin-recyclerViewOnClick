package com.developer.rohal.onclickrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var list: ArrayList<User> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.add(User(R.drawable.three, "Accept your past without regret.Handle your present with confidence.Face your future without fear.", "3.45PM"))
        list.add(User(R.drawable.one, "Handle your present with confidence.Face your future without fear.", "4.45PM"))
        list.add(User(R.drawable.three, "Accept your past without regret.Handle your present with confidence.", "5.45PM"))
        list.add(User(R.drawable.three, "Accept your past without regret.Face your future without fear.", "3.45PM"))
        list.add(User(R.drawable.one, "24 Feb 2017", "4.45PM"))
        list.add(User(R.drawable.three, "25 Feb 2017", "5.45PM"))
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(
                1, //The number of Columns in the grid
                LinearLayoutManager.HORIZONTAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
        var adapter = ContentAdapter(list,object :ContentAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                text.text="item clicked ${position}"
                Toast.makeText(baseContext,"item clicked + ${position}",Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView.adapter = adapter

    }
}
