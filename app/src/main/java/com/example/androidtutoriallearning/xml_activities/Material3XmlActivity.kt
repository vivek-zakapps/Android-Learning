package com.example.androidtutoriallearning.xml_activities

import Ml3RecyclerAdapter
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.view_model.RecyclerViewModel

class Material3XmlActivity : AppCompatActivity() {


    private var currentThemeMode: MutableState<ThemeType> = mutableStateOf(ThemeType.SYSTEM_DEFAULT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_material3_xml)
        setThemeType()
        val recyclerView = findViewById<RecyclerView>(R.id.ml3_recyclerView)
        setML3RecyclerAdaptor(this)
        when(currentThemeMode.value){
            ThemeType.LIGHT->{
                setTheme(R.style.Theme_MyMl3Theme_white)

                recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            }

            ThemeType.DARK -> {
                recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                setTheme(R.style.Theme_MyMl3Theme_Dark)
            }
            ThemeType.SYSTEM_DEFAULT -> {}
            ThemeType.OTHER -> {}
        }



    }

    private fun setML3RecyclerAdaptor(context: Context) {
        val recyclerView = findViewById<RecyclerView>(R.id.ml3_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val dataList = listOf("Item 1", "Item 2", "Item 3") // Your list of data
        val adapter = Ml3RecyclerAdapter(dataList)
        recyclerView.adapter = adapter
        recyclerView.adapter = adapter
    }

    private fun setThemeType() {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        currentThemeMode.value = when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> ThemeType.LIGHT
            Configuration.UI_MODE_NIGHT_YES -> ThemeType.DARK
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                if (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES) {
                    ThemeType.SYSTEM_DEFAULT
                } else {
                    ThemeType.OTHER
                }
            }

            else -> ThemeType.OTHER
        }
    }

    enum class ThemeType {
        LIGHT,
        DARK,
        SYSTEM_DEFAULT,
        OTHER,
    }

}