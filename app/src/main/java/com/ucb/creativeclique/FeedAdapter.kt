package com.ucb.creativeclique

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FeedAdapter(private val feedItems: List<FeedItem>) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val circularImageView: CircleImageView = itemView.findViewById(R.id.circularImageView)
        val usernameTextView: TextView = itemView.findViewById(R.id.username)
        val followerTextView: TextView = itemView.findViewById(R.id.follower)
        val contentTextView: TextView = itemView.findViewById(R.id.content)
        var imageContentTextView: ImageView = itemView.findViewById(R.id.imagecontent)
        var feedContainer: LinearLayout = itemView.findViewById(R.id.feedContainer)
        var commentButton: ImageButton = itemView.findViewById(R.id.commentButton)
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
        holder.feedContainer.setBackgroundResource(R.drawable.signbg)

        holder.commentButton.setOnClickListener {
            val context = holder.itemView.context
            if (context is AppCompatActivity) {
                val bottomSheetDialogFragment = FragmentComment()
                bottomSheetDialogFragment.show(
                    context.supportFragmentManager,
                    "CustomBottomSheetDialogFragment"
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return feedItems.size
    }
}
