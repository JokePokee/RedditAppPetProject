package com.example.reddit_presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_presentation.R

class RedditPageAdapter(
    private val onItemClicked: (RedditPage) -> (Unit),
    private val onScrolledToBottom: () -> (Unit)
) :
    RecyclerView.Adapter<RedditPageAdapter.RedditPageViewHolder>() {


    private var redditPages = mutableListOf<RedditPage>()
        set(value) {
            val diffUtil = object : DiffUtil.Callback() {
                override fun getOldListSize() = field.size

                override fun getNewListSize() = value.size

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return field[oldItemPosition].name == value[newItemPosition].name
                }

                override fun areContentsTheSame(
                    oldItemPosition: Int,
                    newItemPosition: Int
                ): Boolean {
                    return field[oldItemPosition] == value[newItemPosition]
                }
            }
            val diffResult = DiffUtil.calculateDiff(diffUtil)
            field.clear()
            field.addAll(value)
            diffResult.dispatchUpdatesTo(this)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditPageViewHolder {
        return RedditPageViewHolder(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_reddit_page, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return redditPages.size

    }

    override fun onBindViewHolder(holder: RedditPageViewHolder, position: Int) {
        holder.bind(redditPages[position])
        if (position == redditPages.lastIndex) {
            onScrolledToBottom()
        }

    }


    inner class RedditPageViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        fun bind(redditPage: RedditPage) {


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
                onItemClicked(redditPage)
            }

        }
    }

    fun setData(list: List<RedditPage>) {
        redditPages = list.toMutableList()

    }
}
