import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.interfaces.DataPasserInterface

open class SecondFragment : Fragment(R.layout.fragment_second) {


    private var lvInterface: DataPasserInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.fr_btn_2)
        button.setOnClickListener {
            println("hhhhh")
            lvInterface?.onDataPassed("SecondFragmentButtonPressed")

        }

        val data= arguments?.getString("data")
        view.findViewById<TextView>(R.id.fragment_2_text)?.text = data


    }


    override fun onStart() {
        println("sttattatatrt")
        super.onStart()
        Log.d("FirstFragment", "onStart - 2")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FirstFragment", "onResume - 2")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FirstFragment", "onPause - 2")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FirstFragment", "onStop - 2")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FirstFragment", "onDestroyView - 2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FirstFragment", "onDestroy - 2")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FirstFragment", "onDetach - 2")
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