package com.ucb.creativeclique
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentFeed: Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var feedAdapter: FeedAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)

        recyclerView = view.findViewById<RecyclerView>(R.id.feedRecycler)
        val searchButton: ImageButton = view.findViewById(R.id.searchButton)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val feedItems = listOf(
            FeedItem(R.drawable.profile_pic, "Niko Herbias", "100 Followers", "IntProg IntProg IntProg IntProg IntProg IntProg", R.drawable.img),
            FeedItem(R.drawable.profile_pic, "Remard Quimque", "200 Followers", "IntProg IntProg IntProg IntProg IntProg IntProg", R.drawable.img),
            FeedItem(R.drawable.profile_pic, "Ramon Tagli", "200 Followers", "IntProg IntProg IntProg IntProg IntProg IntProg", R.drawable.img),

            )

        feedAdapter = FeedAdapter(feedItems)
        recyclerView.adapter = feedAdapter

        searchButton.setOnClickListener{
            var intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}