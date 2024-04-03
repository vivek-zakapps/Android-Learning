import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtutoriallearning.Adaptors.RecyclerCustomAdapter
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.interfaces.RecyclerviewInterface
import com.example.androidtutoriallearning.view_model.RecyclerViewModel
import com.example.androidtutoriallearning.view_model.RvDataModel
import com.example.androidtutoriallearning.xml_activities.DataPasserXmlActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecycleViewFragment : Fragment(R.layout.fragment_recycle_view) {

    private var rvInterceptor: RecyclerviewInterface? = null
    private lateinit var rvViewModel: RecyclerViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvViewModel = ViewModelProvider(requireActivity()).get(RecyclerViewModel::class.java)

        val recyclerview = view.findViewById<RecyclerView>(R.id.fr_rv_recyclerView)
        val emptyListTextView = view.findViewById<TextView>(R.id.rv_empty_list_text)
        rvViewModel.recyclerViewModelList.observe(viewLifecycleOwner) { dataList ->

            if (dataList.isEmpty()) {
                emptyListTextView.visibility = View.VISIBLE
                recyclerview.visibility = View.GONE
            } else {

                emptyListTextView.visibility = View.GONE
                recyclerview.visibility = View.VISIBLE

                recyclerview.layoutManager =
                    LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
                val adapter = RecyclerCustomAdapter(dataList)
                recyclerview.adapter = adapter
                Log.d("RecycleViewFragment", "Data updated: $dataList")
            }

        }

        listenFabButton(view)
        listenToDeleteBtn(view);
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Ensure the host activity or parent fragment implements RecyclerviewInterface
        rvInterceptor = context as RecyclerviewInterface
        Log.d("RecycleViewFragment", "onAttach")
    }


    private fun listenFabButton(view: View) {
        val fabButtonView = view.findViewById<FloatingActionButton>(R.id.rv_fab_btn)
        fabButtonView.setOnClickListener {
            rvInterceptor?.onEvent("navigate_to_rv_data_entry_fr")
        }
    }

    private fun listenToDeleteBtn(view: View) {



    }
}
