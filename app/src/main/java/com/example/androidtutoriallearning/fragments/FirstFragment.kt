package com.example.androidtutoriallearning.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.interfaces.DataPasserInterface


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class FirstFragment : Fragment(R.layout.fragment_first) {


    private var lvInterface: DataPasserInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val first: TextView = view.findViewById(R.id.fragment_1_text)
        val data = arguments?.getInt("data")
        first.text = data.toString()

        // Notify data has passed
        lvInterface?.onDataPassed(data, "FirstFragment")

    }


    override fun onStart() {
        super.onStart()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            lvInterface = context as DataPasserInterface

        } catch (c: ClassCastException) {
            throw ClassCastException("$context must implement DataPassListener")
        } catch (e: Exception) {
            println(e.toString())
        }
    }

}