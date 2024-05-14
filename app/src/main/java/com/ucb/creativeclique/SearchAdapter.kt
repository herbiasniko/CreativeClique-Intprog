package com.ucb.creativeclique

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class SearchAdapter(context: Context, private val items: ArrayList<SearchItem>) :
    ArrayAdapter<SearchItem>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var currentView = convertView

        if (currentView == null) {
            currentView = LayoutInflater.from(context).inflate(R.layout.search_list, parent, false)
        }
        var currentItem = items[position]
        val itemImage: CircleImageView = currentView!!.findViewById(R.id.imageSearch)
        val itemName: TextView = currentView.findViewById(R.id.textName)

        itemImage.setImageResource(currentItem.imageSearch)
        itemName.text= currentItem.name

        return currentView
    }
}