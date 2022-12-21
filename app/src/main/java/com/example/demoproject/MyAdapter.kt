package com.example.demoproject


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(var mArrayList: ArrayList<String>) :
    RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.my_row1, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data: String = mArrayList[position]
        holder.mTextView.text = data
    }

    override fun getItemCount(): Int {
        return mArrayList.size
    }

    class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTextView: TextView

        init {
            mTextView = v.findViewById(R.id.textView1)
        }
    }
}