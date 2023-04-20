package com.example.reddit_presentation.activity


import android.net.Uri
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_presentation.R
import com.example.reddit_presentation.adapter.RedditPageAdapter

class RedditSetupActivity: AppCompatActivity(), RedditPageAdapter.Listener {

    val adapter = RedditPageAdapter(this) { data ->
        data.name
    }

    val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvRedditPage).apply {
            adapter = this@RedditSetupActivity.adapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView

    }

    override fun onClick(redditPage: RedditPage) {
        val url = "https://reddit.com" + "${redditPage.permalink}"

        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(
            ContextCompat.getColor(
                this@RedditSetupActivity,
                com.google.android.material.R.color.design_default_color_primary
            )
        )
        builder.addDefaultShareMenuItem()

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this@RedditSetupActivity, Uri.parse(url))
    }
}