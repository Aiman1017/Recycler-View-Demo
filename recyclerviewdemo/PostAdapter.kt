package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//Template View Adapter
class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    class PostViewHolder(postView: View) : RecyclerView.ViewHolder(postView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        //We specifying which view to show -> R.layout.post
        val postView = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostViewHolder(postView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 30
    }
}