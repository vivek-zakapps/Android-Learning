package com.example.androidtutoriallearning.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
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

    private var button: Button? = null
    private var first: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        first = view.findViewById(R.id.fragment_1_text)
        button = view.findViewById(R.id.fragment_1_btn)

        val data = arguments?.getString("data")
        first?.text = data

        onclickListener()

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



    private fun onclickListener() {
        button?.setOnClickListener {
            lvInterface?.onDataPassed("Hello Fragment 1")
        }
    }


    fun getDataFromActivity(msg: String) {
        first?.text = msg
    }

}