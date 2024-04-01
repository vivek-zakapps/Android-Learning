package com.example.androidtutoriallearning.fragments

import SecondFragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.interfaces.DataPasserInterface

open class FirstFragment : Fragment(R.layout.fragment_first) {

    private var lvInterface: DataPasserInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstFragment", "onCreate")


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FirstFragment", "onViewCreated")

        val button = view.findViewById<Button>(R.id.fr_btn_1)
        button.setOnClickListener {
            println("hhhhh")
            lvInterface?.onDataPassed( "FirstFragmentButtonPressed")

        }

        try {
           val data= arguments?.getString("data")
            view.findViewById<TextView>(R.id.fragment_1_text)?.text = data



        } catch (e:Exception){
            println(e.toString())
        }


//        val view = view.findViewById<TextView>(R.id.fragment_1_text);
//        view.text = "Navigated back from fragment 2! Supper"

    }


    override fun onStart() {
        println("sttattatatrt")
        super.onStart()
        Log.d("FirstFragment", "onStart")


    }

    override fun onResume() {
        super.onResume()
        Log.d("FirstFragment", "onResume")


    }

    override fun onPause() {
        super.onPause()
        Log.d("FirstFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FirstFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FirstFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FirstFragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FirstFragment", "onDetach")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            lvInterface = context as DataPasserInterface
        } catch (c: ClassCastException) {
            throw ClassCastException("$context must implement DataPassListener")
        } catch (e: Exception) {
            Log.e("FirstFragment", "Error: ${e.toString()}")
        }
        Log.d("FirstFragment", "onAttach")
    }
}
