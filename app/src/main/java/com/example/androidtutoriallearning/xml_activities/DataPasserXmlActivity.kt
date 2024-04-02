package com.example.androidtutoriallearning.xml_activities

import android.os.Bundle
import android.util.Log
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

    private lateinit var viewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        setContentView(R.layout.activity_data_passer)
        val fragmentOne = FirstFragmentClass.newInstance("data", viewModel.data.value?:"hi")
        replaceFragment(fragmentOne)
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
        if (data == "FirstFragmentButtonPressed") {
            println("Hellllllooo")
            viewModel.updateText("Navigated from fragment 1! Supper")
            replaceFragment(SecondFragmentClass.newInstance("data", viewModel.data.value?:"hi"))
        } else if (data == "SecondFragmentButtonPressed") {
            viewModel.updateText("Navigated back from fragment 2! Supper")
            replaceFragment(FirstFragmentClass.newInstance("data", viewModel.data.value?:"hi"))
        }

    }


}
