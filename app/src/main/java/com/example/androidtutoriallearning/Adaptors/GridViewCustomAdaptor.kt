package com.example.androidtutoriallearning.Adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.models.ItemsViewModel


class GridViewCustomAdaptorAdapter(context: Context, courseModelArrayList: ArrayList<ItemsViewModel>) :
    ArrayAdapter<ItemsViewModel?>(context,0 ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listItemView = convertView
        if (listItemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listItemView = LayoutInflater.from(context).inflate(R.layout.card_view_design, parent, false)
        }

        val courseModel: ItemsViewModel? = getItem(position)
        val title = listItemView!!.findViewById<TextView>(R.id.card_textView)
        val image = listItemView.findViewById<ImageView>(R.id.card_imageview)

        if (courseModel != null) {
            title.text = "heuuuu"
            image.setImageResource(R.drawable.person)
        }

        return listItemView
    }
}
