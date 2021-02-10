package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.MockDatabase.Companion.createMockData
import com.example.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PostAdapter.OnPostClickListener {
    //Call the dummy data
    val dummyList = createMockData()
    //PostAdapter object has the reference to dummyList as parameter
    val adapter = PostAdapter(dummyList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //Pass the data in the Adapter
        recyclerView.adapter = adapter
    }

    override fun onEditPost(position: Int) {
        //The post that we want to update
        val clickedPost = dummyList[position]
        clickedPost.title = "Updated title"
        clickedPost.body = "Updated body"
        adapter.notifyItemChanged(position)
    }

    override fun onDeletePost(position: Int) {
        dummyList.removeAt(position)
        //The adapter will notify the view and remove the item
        adapter.notifyItemRemoved(position)
    }
}