package com.example.androidtutoriallearning.Adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.interfaces.RecyclerviewInterface
import com.example.androidtutoriallearning.view_model.RvDataModel

class RecyclerCustomAdapter(private val mList: List<RvDataModel>) :
    RecyclerView.Adapter<RecyclerCustomAdapter.ViewHolder>() {

    private var rvInterceptor: RecyclerviewInterface? = null




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        rvInterceptor = parent.context as RecyclerviewInterface

        return ViewHolder(view)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(R.drawable.person)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.name
        holder.deleteBtn.text = position.toString()
        holder.deleteBtn.setOnClickListener {
            rvInterceptor?.onDeleteButtonClick(position)
        }
        holder.dataTile.setOnClickListener {
            rvInterceptor?.onCardTilePress(position)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.card_imageview)
        val textView: TextView = itemView.findViewById(R.id.card_textView)
        val deleteBtn: Button = itemView.findViewById(R.id.rv_delete_btn)
        val dataTile: CardView = itemView.findViewById(R.id.rv_card_tile)

    }
}
