package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Template View Adapter
class PostAdapter(val dummyData: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    //The View will references to ViewHolder by postView
    class PostViewHolder(postView: View) : RecyclerView.ViewHolder(postView){
        val iconImage: ImageView = postView.findViewById(R.id.icon_image_view)
        val title: TextView = postView.findViewById(R.id.title)
        val body: TextView = postView.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        //We specifying which view to show -> R.layout.post
        val postView = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostViewHolder(postView)
    }

    //Bind data with the ViewHolder
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = dummyData[position]
        holder.iconImage.setImageResource(currentPost.iconImage)
        holder.title.text = currentPost.title
        holder.body.text = currentPost.body
    }

    override fun getItemCount(): Int {
        return dummyData.size
    }
}