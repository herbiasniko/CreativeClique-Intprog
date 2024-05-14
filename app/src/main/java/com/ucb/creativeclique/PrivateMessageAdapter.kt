package com.ucb.creativeclique

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrivateMessageAdapter(private val messages: List<PrivateMessageSealed>) :
    RecyclerView.Adapter<PrivateMessageAdapter.MessageViewHolder>() {

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textMessage: TextView = itemView.findViewById(R.id.textMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutId = when (viewType) {
            PrivateMessageSealed.VIEW_TYPE_SENDER -> R.layout.item_private_message_sender
            PrivateMessageSealed.VIEW_TYPE_RECEIVER -> R.layout.item_private_message_receiver
            else -> throw IllegalArgumentException("Invalid view type")
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.textMessage.text = message.text
    }

    override fun getItemViewType(position: Int): Int {
        return messages[position].getViewType()
    }

    override fun getItemCount(): Int {
        return messages.size
    }
}