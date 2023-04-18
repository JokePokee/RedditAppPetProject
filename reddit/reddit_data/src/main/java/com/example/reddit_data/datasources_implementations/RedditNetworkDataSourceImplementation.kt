package com.example.reddit_data.datasources_implementations

import com.example.reddit_data.datasources.RedditNetworkDataSource
import com.example.reddit_data.network_service.RedditPageApi
import com.example.reddit_data.toRedditPageList
import com.example.reddit_domain.dispatcher.DefaultDispatcherProvider
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_domain.repositories.RedditRepository
import kotlinx.coroutines.withContext

class RedditNetworkDataSourceImplementation(private val redditPageApi: RedditPageApi) :
    RedditNetworkDataSource {

    override suspend fun fetchData(nameId: String?, pageCount: Int): List<RedditPage> {
        return redditPageApi.getDataFromPage().toRedditPageList()
    }
}