package com.ucb.creativeclique

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MessageActivity : AppCompatActivity(),  MessageAdapter.OnItemClickListener {

    private lateinit var messageRecyclerView: RecyclerView
    private lateinit var messageAdapter: MessageAdapter

    private val messages = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        // Initialize RecyclerView
        messageRecyclerView = findViewById(R.id.messageRecyclerView)
        messageAdapter = MessageAdapter(messages, this)
        messageRecyclerView.adapter = messageAdapter

        // Fetch messages from somewhere and add to the list
        fetchMessages()
    }

    private fun fetchMessages() {
        // Fetch messages from database or any other source
        // Add messages to the messages list
        messages.add(Message("John", "Hello!", System.currentTimeMillis()))
        messages.add(Message("Alice", "Hi there!", System.currentTimeMillis()))
        // Notify adapter about the data change
        messageAdapter.notifyDataSetChanged()
    }

    override fun onItemClick(message: Message) {
        // Handle item click
        // For example, you can display a toast with the clicked message
        Toast.makeText(this, "Clicked on ${message.sender}", Toast.LENGTH_SHORT).show()
    }
}