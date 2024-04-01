package com.example.androidtutoriallearning.xml_activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.Adaptors.CustomAdapter
import com.example.androidtutoriallearning.models.ItemsViewModel

class RecyclerViewXmlPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_xml_practice)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        /*
        * If you want to make the scroll horizontally then
        *   recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        *
        * */
        recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)


        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.person, "Item $i"))
        }



        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}