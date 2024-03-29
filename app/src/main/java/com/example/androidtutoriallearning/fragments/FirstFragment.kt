package com.example.androidtutoriallearning.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.interfaces.ListviewInterface


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class FirstFragment : Fragment(R.layout.fragment_first) {


    private var lvInterface: ListviewInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val first: TextView = view.findViewById(R.id.fragment_1_text)
        val data = arguments?.getString("data")
        first.text = data

    }


    override fun onStart() {
        super.onStart()
        lvInterface?.onDataPassed("Returned" ?: "")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            lvInterface = context as ListviewInterface

        } catch (c: ClassCastException) {
            throw ClassCastException("$context must implement DataPassListener")
        } catch (e: Exception) {
            println(e.toString())
        }
    }

}