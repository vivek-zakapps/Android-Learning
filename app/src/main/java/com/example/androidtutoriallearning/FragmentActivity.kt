package com.example.androidtutoriallearning

import android.os.Bundle

import androidx.activity.ComponentActivity


class FragmentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fragment)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment ()
//        supportFragmentManager.beginTransaction().apply() {
//            replace(R.id.flfragment, firstFragment)
//            commit()
//        }






    }

}