package com.ucb.creativeclique

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(private val messages: List<Message>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(message: Message)
    }

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
        private val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
        private val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)

        fun bind(message: Message) {
            senderTextView.text = message.sender
            contentTextView.text = message.content

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(messages[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item_layout, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount(): Int {
        return messages.size
    }
}
