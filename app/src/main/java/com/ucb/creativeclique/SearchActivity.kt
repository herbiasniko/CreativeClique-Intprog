package com.ucb.creativeclique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView


class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var listView: ListView = findViewById(R.id.listView)
        var arrowBack: ImageButton = findViewById(R.id.ArrowBack)

        var items = ArrayList<SearchItem>()

        items.add(SearchItem(R.drawable.profile_pic, "Ramon Alejandro"))
        items.add(SearchItem(R.drawable.profile_pic, "Ramon Alejandro"))
        items.add(SearchItem(R.drawable.profile_pic, "Ramon Alejandro"))

        var adapter = SearchAdapter(this, items)
        listView.adapter = adapter

        arrowBack.setOnClickListener {
            onBackPressed()
        }






    }
}