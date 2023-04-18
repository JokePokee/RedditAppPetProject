package com.example.reddit_data.datasources

import com.example.reddit_domain.model.RedditPage

interface RedditNetworkDataSource {

    suspend fun fetchData(nameId: String? = null, pageCount: Int): List<RedditPage>
}