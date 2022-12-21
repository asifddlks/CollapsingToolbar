package com.example.demoproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TabOne:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.tab1, container, false)

        val recyclerView = v.findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        val dataList: ArrayList<String> = ArrayList()
        var ch = 'A'
        while (ch <= 'Z') {
            dataList.add(ch.toString())
            ch++
        }
        val mAdapter = MyAdapter(dataList)
        recyclerView.adapter = mAdapter
        return v
    }



}