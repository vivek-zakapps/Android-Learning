package com.example.androidtutoriallearning.xml_activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.classes.FirstFragmentClass
import com.example.androidtutoriallearning.classes.SecondFragmentClass
import com.example.androidtutoriallearning.interfaces.DataPasserInterface
import kotlin.random.Random

class DataPasserXmlActivity : AppCompatActivity(), DataPasserInterface {

    var d = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_data_passer)


        d =0;
        val fragmentOne = FirstFragmentClass.newInstance("data", d)
        replaceFragment(fragmentOne)


        findViewById<Button>(R.id.lv_fragment_2_btn).setOnClickListener {

            println("In activity btn 2")
            replaceFragment(SecondFragmentClass.newInstance("data", d))
        }

        findViewById<Button>(R.id.lv_fragment_1_btn).setOnClickListener {
            replaceFragment(FirstFragmentClass.newInstance("data", d))
        }


    }





    private fun listenLVButton2(initialData: Int?) {
        var data = initialData
        findViewById<Button>(R.id.lv_fragment_2_btn).setOnClickListener {
            data = (data ?: 0) + 1
            this.d = data!!
            println("BUTTON @ 2 CLICKED => $d")
            replaceFragment(SecondFragmentClass.newInstance("data", data!!))
        }
    }


    private fun listenLvButton1(initialData: Int?) {
        var data = initialData;
        findViewById<Button>(R.id.lv_fragment_1_btn).setOnClickListener {
            // Increment the data value
            data = (data ?: 0) + 1
            this.d = data!!

            println("BUTTON @ 1 CLICKED => $data")
            replaceFragment(FirstFragmentClass.newInstance("data", data!!))
        }
    }


    // Replace fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.lv_fragments, fragment);
            disallowAddToBackStack();
            commit();
        }
    }

    override fun onDataPassed(data: Int?, fragment: String) {
        Log.d("MainActivity", "Data received from fragment: $data return ++++")
        if (fragment.toString().contains("FirstFragment")) {
           println("lll - 1")
            listenLvButton1(data)
        } else {
            println("lll - 2")
            listenLVButton2(data)
        }

    }


    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        //super.onBackPressed()
    }
}
