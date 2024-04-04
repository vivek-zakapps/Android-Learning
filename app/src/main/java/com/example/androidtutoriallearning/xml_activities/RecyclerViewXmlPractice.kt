package com.example.androidtutoriallearning.xml_activities

import RecycleViewFragment
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.Adaptors.RecyclerCustomAdapter
import com.example.androidtutoriallearning.classes.RvDataEntryFragmentClass
import com.example.androidtutoriallearning.fragments.RvDataEntryFragment
import com.example.androidtutoriallearning.fragments.RvUpdateDialogueFragment
import com.example.androidtutoriallearning.interfaces.RecyclerviewInterface
import com.example.androidtutoriallearning.jetpack_activities.EmptyScreenActivity
import com.example.androidtutoriallearning.models.ItemsViewModel
import com.example.androidtutoriallearning.view_model.RecyclerViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewXmlPractice : AppCompatActivity(), RecyclerviewInterface {

    private lateinit var rvViewModel: RecyclerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycler_view_xml_practice)
        rvViewModel = ViewModelProvider(this)[RecyclerViewModel::class.java]

        val rvListView = RecycleViewFragment();
        replaceFragmentView(rvListView)

    }


    private fun replaceFragmentView(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.rv_fragment, fragment)
            disallowAddToBackStack()
            commit()
        }
    }

    override fun onEvent(event: String) {
        when (event) {
            "navigate_to_rv_data_entry_fr" -> {
                replaceFragmentView(RvDataEntryFragment())
            }

            "data_added_to_rv_list" -> {
                replaceFragmentView(RecycleViewFragment())
            }
        }

    }

    override fun onDeleteButtonClick(id: Int) {
        println("Delete button clicked $id")
        rvViewModel.removeFromList(id)
    }

    override fun onCardTilePress(position: Int) {
        println("cloclccllclc")
        val dialogFragment = RvUpdateDialogueFragment.newInstance(position)
        dialogFragment.show(supportFragmentManager, "GAME_DIALOG")
    }





}