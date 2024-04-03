package com.example.androidtutoriallearning.fragments

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.view_model.RecyclerViewModel
import com.example.androidtutoriallearning.view_model.RvDataModel


class RvUpdateDialogueFragment : DialogFragment() {

    private lateinit var rvViewModel: RecyclerViewModel

    companion object {
        private const val postition = "position";

        // Function to create a new instance of the fragment with arguments
        fun newInstance(data: Int): RvUpdateDialogueFragment {
            val fragment = RvUpdateDialogueFragment()
            val args = Bundle().apply {
                putInt(postition, data)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.activity_rv_update_dialogue, null)

        // Get ViewModel data reference
        rvViewModel = ViewModelProvider(requireActivity()).get(RecyclerViewModel::class.java)
        val rvList = rvViewModel.recyclerViewModelList.value;


        // Get references to views
        val editText = dialogView.findViewById<EditText>(R.id.editText)
        val btnUpdate = dialogView.findViewById<Button>(R.id.rv_lv_btnUpdate)
        val btnCancel = dialogView.findViewById<Button>(R.id.rv_lv_btnCancel)

        val i = arguments?.getInt(postition) ?: 0
        val text = rvList?.get(i)?.name ?: "empty"

        // set the text in ui
        editText.setText(text)

        btnUpdate.setOnClickListener {
            val name = editText.text.toString()
            rvViewModel.updateData(i, RvDataModel(name))
            dismiss()
        }

        btnCancel.setOnClickListener {

            dismiss()
        }

        // Create dialog with custom layout
        return AlertDialog.Builder(requireActivity())
            .setView(dialogView)
            .create()
    }
}
