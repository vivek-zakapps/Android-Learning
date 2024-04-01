import android.content.Context
import android.os.Bundle
import android.view.View
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
        val textView: TextView = view.findViewById(R.id.fragment_2_text)
        val arguments = requireArguments()
        val data = arguments.getInt("data")
        textView.text = data.toString()

        // Notify data has passed
        lvInterface?.onDataPassed(data, "SecondFragment")

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