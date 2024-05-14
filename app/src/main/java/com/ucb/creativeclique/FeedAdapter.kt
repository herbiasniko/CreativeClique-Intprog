package com.ucb.creativeclique

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class FeedAdapter(private val feedItems: List<FeedItem>) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val circularImageView: CircleImageView = itemView.findViewById(R.id.circularImageView)
        val usernameTextView: TextView = itemView.findViewById(R.id.username)
        val followerTextView: TextView = itemView.findViewById(R.id.follower)
        val contentTextView: TextView = itemView.findViewById(R.id.content)
        var imageContentTextView: ImageView = itemView.findViewById(R.id.imagecontent)
        var feedContainer: LinearLayout = itemView.findViewById(R.id.feedContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val item = feedItems[position]
        holder.circularImageView.setImageResource(item.image1)
        holder.usernameTextView.text = item.username
        holder.followerTextView.text = item.followers
        holder.contentTextView.text = item.content
        holder.imageContentTextView.setImageResource(item.image2)
        holder.feedContainer.setBackgroundResource(R.drawable.color)

        holder.circularImageView.setOnClickListener {
           
        }
    }

    override fun getItemCount(): Int {
        return feedItems.size
    }
}
