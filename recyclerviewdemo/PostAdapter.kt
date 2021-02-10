package com.example.recyclerviewdemo

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Template View Adapter
class PostAdapter(val dummyData: ArrayList<Post>, val myListener: OnPostClickListener) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    //Add reference
    //The View will references to ViewHolder by postView
    inner class PostViewHolder(postView: View) : RecyclerView.ViewHolder(postView), View.OnClickListener{
        val iconImage: ImageView = postView.findViewById(R.id.icon_image_view)
        val title: TextView = postView.findViewById(R.id.title)
        val body: TextView = postView.findViewById(R.id.body)
        val deleteImage: ImageView = postView.findViewById(R.id.delete_post_image)
        val editPost: ImageView = postView.findViewById(R.id.edit_post_image)

        //Refer the Listener on the delete button itself
        init {
            deleteImage.setOnClickListener(this)
            editPost.setOnClickListener(this)
        }

        //Click Event
        override fun onClick(v: View?) {
            val position = adapterPosition
            if(v?.id == editPost.id){
                myListener.onEditPost(position)
            }else {
                myListener.onDeletePost(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        //We specifying which view to show -> R.layout.post
        val postView = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostViewHolder(postView)
    }

    //Bind data with the ViewHolder
    //by using the dummy data
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = dummyData[position]
        holder.iconImage.setImageResource(currentPost.iconImage)
        holder.title.text = currentPost.title
        holder.body.text = currentPost.body
    }

    override fun getItemCount(): Int {
        //Refer to data size/range
        return dummyData.size
    }

    interface OnPostClickListener{
        fun onEditPost(position: Int)
        fun onDeletePost(position: Int)
    }
}