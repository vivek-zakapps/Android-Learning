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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_data_passer)


        val data = Random.nextInt(1000, 10000).toString();
        val fragmentOne = FirstFragmentClass.newInstance("data", data)
        replaceFragment(fragmentOne)



        findViewById<Button>(R.id.lv_fragment_2_btn).setOnClickListener {

            val data = Random.nextInt(1000, 10000).toString();

            println((data))
            replaceFragment(SecondFragmentClass.newInstance("data", data.toString()))
        }

        findViewById<Button>(R.id.lv_fragment_1_btn).setOnClickListener {
            val data = Random.nextInt(1000, 10000).toString();
            replaceFragment(FirstFragmentClass.newInstance("data", data.toString()))
        }


    }


    private fun listenLVButton2(initialData: Any?) {
        var data = initialData
        findViewById<Button>(R.id.lv_fragment_2_btn).setOnClickListener {
            if (data == null) {
                data = Random.nextInt(1000, 10000).toString();
            }
            println((data))
            replaceFragment(SecondFragmentClass.newInstance("data", data.toString()))
        }
    }


    private fun listenLvButton2(initialData: Any?) {
        var data = initialData;
        findViewById<Button>(R.id.lv_fragment_1_btn).setOnClickListener {
            if (data == null) {
                data = Random.nextInt(1000, 10000).toString();
            }
            replaceFragment(FirstFragmentClass.newInstance("data", data.toString()))
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

    override fun onDataPassed(data: String) {
        Log.d("MainActivity", "Data received from fragment: $data return ++++")
        listenLVButton2("Data from fragment 1 : $data")
    }


    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        //super.onBackPressed()
    }
}
