package com.example.reddit_presentation.activity


import android.net.Uri
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_presentation.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.reddit_presentation.adapter.RedditPageAdapter
import com.example.reddit_presentation.viewmodel.RedditSetupViewModel

class RedditSetupActivity : AppCompatActivity() {

    val adapter = RedditPageAdapter(onItemClicked = {
        viewModel.onItemClicked(it)
    }, onScrolledToBottom = {
        viewModel.onPagination()
    })

    private val viewModel: RedditSetupViewModel by viewModel()

    val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvRedditPage).apply {
            adapter = this@RedditSetupActivity.adapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this@RedditSetupActivity)

        viewModel.redditLiveData.observe(this, Observer {
            it?.let { adapter.setData(it) }
        })
        //viewModel.redditLiveData.value?.let { adapter.setData(it) }


    }

}