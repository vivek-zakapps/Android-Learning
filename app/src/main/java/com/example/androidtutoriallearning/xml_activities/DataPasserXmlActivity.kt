package com.example.androidtutoriallearning.xml_activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.classes.FirstFragmentClass
import com.example.androidtutoriallearning.classes.SecondFragmentClass
import com.example.androidtutoriallearning.interfaces.DataPasserInterface
import com.example.androidtutoriallearning.view_model.DataViewModel
import kotlin.random.Random


class DataPasserXmlActivity : AppCompatActivity(), DataPasserInterface {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_passer)
        val fragmentOne = FirstFragmentClass.newInstance("data", "HI")
        replaceFragment(fragmentOne)
    }


    // Replace fragment
    private fun replaceFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction().apply {
                println("replaceFragment Called")
                replace(R.id.lv_fragments, fragment)
                addToBackStack("fragment_transaction")
                commit()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDataPassed(data: String) {
        when (data) {
            "FirstFragmentButtonPressed" -> {
                // Navigate to the second fragment
                replaceFragment(SecondFragmentClass.newInstance("data", "Navigated from fragment 1! Supper"))
            }
            "SecondFragmentButtonPressed" -> {
                // Navigate back to the first fragment
                replaceFragment(FirstFragmentClass.newInstance("data", "Navigated back from fragment 2! Supper"))
            }
        }



    }


    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }


}
