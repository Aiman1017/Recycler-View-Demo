package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.MockDatabase.Companion.createMockData
import com.example.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //Call the dummy data
        val dummyList = createMockData()

        //Pass the data in the Adapter
        recyclerView.adapter = PostAdapter(dummyList)
    }
}