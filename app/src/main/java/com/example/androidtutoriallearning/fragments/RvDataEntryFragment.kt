package com.example.androidtutoriallearning.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModelProvider
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.interfaces.RecyclerviewInterface
import com.example.androidtutoriallearning.view_model.RecyclerViewModel
import com.example.androidtutoriallearning.view_model.RvDataModel
import java.util.Locale

open class RvDataEntryFragment : Fragment(R.layout.fragment_rv_data_entry) {


    private var rvInterceptor: RecyclerviewInterface? = null
    private lateinit var rvViewModel: RecyclerViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvViewModel = ViewModelProvider(requireActivity())[RecyclerViewModel::class.java]





        val submitButton = view.findViewById<Button>(R.id.rv_add_rv_data_btn)



        submitButton.setOnClickListener {
            val editTextView = view.findViewById<EditText>(R.id.rv_edit_Text)
            println("Textyrtyr : ${editTextView.text.toString()}")

            rvViewModel.addToList(RvDataModel(editTextView.text.toString()));
            rvInterceptor?.onEvent("data_added_to_rv_list")
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            rvInterceptor = context as RecyclerviewInterface
        } catch (c: ClassCastException) {
            throw ClassCastException("$context must implement DataPassListener")
        } catch (e: Exception) {
            Log.e("FirstFragment", "Error: ${e.toString()}")
        }
        Log.d("FirstFragment", "onAttach")
    }

}