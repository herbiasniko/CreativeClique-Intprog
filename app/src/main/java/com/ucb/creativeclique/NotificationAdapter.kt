package com.ucb.creativeclique

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class NotificationAdapter(private val items: List<NotificationItem>) :
    RecyclerView.Adapter<NotificationAdapter.MergedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MergedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_header, parent, false)
        return MergedViewHolder(view)
    }

    override fun onBindViewHolder(holder: MergedViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is NotificationItem.Header -> HEADER_VIEW_TYPE
            is NotificationItem.Notification -> NOTIFICATION_VIEW_TYPE
        }
    }

    inner class MergedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val notificationLayout: View = itemView.findViewById(R.id.notificationLayout)
        private val profileImageView: CircleImageView = itemView.findViewById(R.id.profileImageView)
        private val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)

        fun bind(item: NotificationItem) {
            when (item) {
                is NotificationItem.Header -> {
                    titleTextView.visibility = View.VISIBLE
                    notificationLayout.visibility = View.GONE
                    titleTextView.text = item.title
                }
                is NotificationItem.Notification -> {
                    titleTextView.visibility = View.GONE
                    notificationLayout.visibility = View.VISIBLE
                    profileImageView.setImageResource(item.profileImageRes)
                    val formattedMessage = item.message.replace("Niko Herbias", "<b>Niko Herbias</b>")
                    messageTextView.text = Html.fromHtml(formattedMessage, Html.FROM_HTML_MODE_COMPACT)
                }
            }
        }
    }

    companion object {
        private const val HEADER_VIEW_TYPE = 0
        private const val NOTIFICATION_VIEW_TYPE = 1
    }
}