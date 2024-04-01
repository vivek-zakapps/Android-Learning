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


        findViewById<Button>(R.id.lv_fragment_1_btn).setOnClickListener {
            replaceFragment(FirstFragmentClass.newInstance("data", "Display fragment 1 Screen"))
        }

        findViewById<Button>(R.id.lv_fragment_2_btn).setOnClickListener {
            replaceFragment(SecondFragmentClass.newInstance("data", "Display fragment 2 Screen"))
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


    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onDataPassed(data: String) {
        Log.d("MainActivity", "Data received from fragment: $data return ++++")
        fragment1().getDataFromActivity(data)
    }

    private fun fragment1(): FirstFragmentClass {
        return supportFragmentManager.findFragmentById(R.id.lv_fragments) as FirstFragmentClass
    }


}
