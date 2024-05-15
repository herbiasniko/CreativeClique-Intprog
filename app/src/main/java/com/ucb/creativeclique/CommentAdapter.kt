package com.ucb.creativeclique

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CommentAdapter(private var items: ArrayList<CommentItem>):
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var commentImage: CircleImageView = itemView.findViewById(R.id.imageComment)
        var commentName: TextView = itemView.findViewById(R.id.textName)
        var commentText: TextView = itemView.findViewById(R.id.textComment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_layout, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var item = items[position]
        holder.commentImage.setImageResource(item.imageComment)
        holder.commentName.text = item.nameComment
        holder.commentText.text = item.comment

    }
    override fun getItemCount(): Int {
        return items.size
    }

}