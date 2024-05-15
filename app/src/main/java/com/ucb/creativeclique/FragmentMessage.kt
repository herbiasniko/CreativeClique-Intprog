package com.ucb.creativeclique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ucb.creativeclique.FragmentFeed
import com.ucb.creativeclique.MainActivity
import com.ucb.creativeclique.Message
import com.ucb.creativeclique.MessageAdapter
import com.ucb.creativeclique.R

class FragmentMessage : Fragment(), MessageAdapter.OnItemClickListener {

    private lateinit var messageRecyclerView: RecyclerView
    private lateinit var messageAdapter: MessageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        // Find views
        val arrowBack: ImageButton = view.findViewById(R.id.backButt)
        messageRecyclerView = view.findViewById(R.id.messageRecyclerView)

        // Set up RecyclerView
        messageAdapter = MessageAdapter(getSampleMessages(), this) // Replace this with your actual messages
        messageRecyclerView.adapter = messageAdapter
        messageRecyclerView.layoutManager = LinearLayoutManager(context)

//        // Handle back button click
        arrowBack.setOnClickListener {
            // Create a FragmentFeed instance
            val fragmentFeed = FragmentFeed()

            // Begin the transaction
            requireActivity().supportFragmentManager.beginTransaction()
                // Replace the current fragment with FragmentFeed
                .replace(R.id.fragment_container, fragmentFeed)
                // Add the transaction to the back stack
                .addToBackStack(null)
                // Commit the transaction
                .commit()
        }


        return view
    }
    override fun onItemClick(message: Message) {
        // Handle item click
        // For example, you can display a toast with the sender name
        var privateMessage = FragmentPrivateMessage()
        requireActivity().supportFragmentManager.beginTransaction()
            // Replace the current fragment with FragmentFeed
            .replace(R.id.fragment_container, privateMessage)
            // Add the transaction to the back stack
            .addToBackStack(null)
            // Commit the transaction
            .commit()
    }


    // Function to generate sample messages (Replace this with your actual message fetching logic)
    private fun getSampleMessages(): List<Message> {
        return listOf(
            Message("Ramon Gwapo", "Tomboy man to siya", System.currentTimeMillis()),
            Message("Remard Quickie", "Sir bsag tres lang sir", System.currentTimeMillis()),
            Message("Niko Loco", "Mao gyud sir unta makapasar", System.currentTimeMillis()),
            Message("Patrick Tombs", "Hi there!", System.currentTimeMillis()),
            Message("Joniel Kalonia", "Hi there!", System.currentTimeMillis()),
            Message("Pontot Japson", "Hi there!", System.currentTimeMillis()),
            Message("Ade Babaan", "Hi there!", System.currentTimeMillis()),
            Message("Lumapac Joy", "Hi there!", System.currentTimeMillis()),
            Message("Mira Niel", "Hi there!", System.currentTimeMillis()),
            Message("Joem Gwaps", "Hi there!", System.currentTimeMillis())

        )
    }



    // Optionally, you can add a function to handle back button presses
    fun handleBackPressed() {
        requireActivity().supportFragmentManager.popBackStack()
    }

}