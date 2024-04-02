package com.example.androidtutoriallearning.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.interfaces.DataPasserInterface
import com.example.androidtutoriallearning.view_model.DataViewModel


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
        // Initialize ViewModel
        val viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)

        // Observe changes in textLiveData
        viewModel.data.observe(viewLifecycleOwner) { newText ->
            view.findViewById<TextView>(R.id.fragment_1_text)?.text = newText
        }

        val button = view.findViewById<Button>(R.id.fr_btn_1)
        button.setOnClickListener {
            lvInterface?.onDataPassed("FirstFragmentButtonPressed")
        }


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



//    private fun onclickListener() {
//        button?.setOnClickListener {
//            lvInterface?.onDataPassed("Hello Fragment 1")
//        }
//    }
//
//
//    fun getDataFromActivity(msg: String) {
//        first?.text = msg
//    }

}