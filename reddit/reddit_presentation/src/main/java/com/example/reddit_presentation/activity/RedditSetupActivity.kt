package com.example.reddit_presentation.activity


import android.net.Uri
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_presentation.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.reddit_presentation.adapter.RedditPageAdapter
import com.example.reddit_presentation.viewmodel.RedditSetupViewModel

class RedditSetupActivity: AppCompatActivity(), RedditPageAdapter.Listener {

    val adapter = RedditPageAdapter(this) { data ->
        data.name
    }

    private val viewModel: RedditSetupViewModel by viewModel()

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