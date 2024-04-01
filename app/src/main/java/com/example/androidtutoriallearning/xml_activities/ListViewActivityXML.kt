package com.example.androidtutoriallearning.xml_activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.classes.FirstFragmentClass
import com.example.androidtutoriallearning.classes.SecondFragmentClass
import com.example.androidtutoriallearning.fragments.FirstFragment
import com.example.androidtutoriallearning.fragments.SecondFragment
import com.example.androidtutoriallearning.interfaces.ListviewInterface
import kotlin.random.Random

class ListViewActivityXML : AppCompatActivity(), ListviewInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_list_view)


//        val data = Random.nextInt(1000, 10000).toString();
//        val fragmentOne = FirstFragmentClass.newInstance("data", data)
//        replaceFragment(fragmentOne)


        val clicked: Boolean = true;

//        if (clicked){
            findViewById<Button>(R.id.lv_fragment_1_btn).setOnClickListener {
                val data = Random.nextInt(1000, 10000).toString();
                replaceFragment(FirstFragmentClass.newInstance("data", data))
            }
//        }else{
//            onDataPassed("returned")
//        }


        findViewById<Button>(R.id.lv_fragment_2_btn).setOnClickListener {
            val data = Random.nextInt(1000, 10000).toString();
            println((data))
            replaceFragment(SecondFragmentClass.newInstance("data", data))
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
        val view:TextView = findViewById(R.id.fragment_1_text)
        view.text=data;
       // firstFragment().getData(data)
    }
    private fun firstFragment(): FirstFragment {
        return supportFragmentManager.findFragmentById(R.id.lv_fragments) as FirstFragment
    }
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        //super.onBackPressed()
    }
}
