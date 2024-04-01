package com.example.androidtutoriallearning.xml_activities

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutoriallearning.Adaptors.GridViewCustomAdaptorAdapter
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.models.ItemsViewModel

class GridViewBuilder : AppCompatActivity() {

    private lateinit var coursesGV: GridView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_view_builder)
        coursesGV = findViewById(R.id.idGVcourses)
        val courseModelArrayList: ArrayList<ItemsViewModel> = ArrayList<ItemsViewModel>()


        for (i in 1..10){
            courseModelArrayList.add(ItemsViewModel( 100, "data : $i"))
        }



        val adapter = GridViewCustomAdaptorAdapter(this, courseModelArrayList)
        coursesGV.adapter = adapter
    }
}