package com.example.androidtutoriallearning.jetpack_activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.fragments.FirstFragment
import com.example.androidtutoriallearning.fragments.SecondFragment

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fragment)
         val firstFragment = FirstFragment()
         val secondFragment = SecondFragment ()


        replaceFragment(firstFragment)

        // Function to change fragment by clicking fragment 1 button
        findViewById<Button>(R.id.btnFragment1).setOnClickListener {
            replaceFragment(firstFragment)
        }

        // Function to change fragment by clicking fragment 1 button
        findViewById<Button>(R.id.btnFragment2).setOnClickListener {
            replaceFragment(secondFragment)
        }


    }

    // Function to replace the current fragment with a new one
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            addToBackStack(null) // Optional: Add transaction to back stack
            commit()
        }
    }
}