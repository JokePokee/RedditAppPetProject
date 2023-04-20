package com.example.reddit_presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_presentation.R
import com.example.reddit_presentation.viewmodel.RedditSetupViewModel

class RedditPageAdapter(val listener: Listener, val onScrolledToBottom: (RedditPage) -> (Unit)) :
    RecyclerView.Adapter<RedditPageAdapter.RedditPageViewHolder>() {


    private val viewModel: RedditSetupViewModel by viewModel()
    private val data = mutableListOf<RedditPage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditPageViewHolder {
        return RedditPageViewHolder(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_reddit_page, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    
    }

    override fun onBindViewHolder(holder: RedditPageViewHolder, position: Int) {
        holder.bind(data[position], listener)
        if (position == data.lastIndex) {
            onScrolledToBottom(data[position])
        }

    }


    class RedditPageViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        fun bind(redditPage: RedditPage, listener: Listener) {


            itemView.findViewById<TextView>(R.id.tvSubreddit).apply {
                text = redditPage.subreddit
            }
            itemView.findViewById<TextView>(R.id.tvAuthor).apply {
                text = redditPage.author
            }
            itemView.findViewById<TextView>(R.id.tvPostDate).apply {
                text = redditPage.postDate.toString()
            }
            itemView.findViewById<TextView>(R.id.tvTitle).apply {
                text = redditPage.title
            }
            itemView.findViewById<TextView>(R.id.tvNumberOfComments).apply {
                text = redditPage.numberOfComments.toString()
            }
            itemView.findViewById<TextView>(R.id.tvCurrentRating).apply {
                text = redditPage.currentRating.toString()
            }
            itemView.findViewById<ImageView>(R.id.ivThumbnail).apply {
                Glide.with(itemView.context)
                    .load(redditPage.thumbnail)
                    .into(this)
            }
            itemView.setOnClickListener {
                listener.onClick(redditPage)
            }

        }
    }

    fun setData(list: List<RedditPage>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()

    }

    interface Listener {
        fun onClick(redditPage: RedditPage)
    }

}