package com.example.reddit_data.repositories

import com.example.reddit_data.datasources.RedditNetworkDataSource
import com.example.reddit_data.network_service.RedditPageApi
import com.example.reddit_data.toRedditPageList
import com.example.reddit_domain.dispatcher.DefaultDispatcherProvider
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_domain.repositories.RedditRepository
import kotlinx.coroutines.withContext

class RedditRepositoryImplementation(private val redditNetworkDataSource: RedditNetworkDataSource) :
    RedditRepository {

    override suspend fun fetchData(nameId: String?, pageCount: Int): List<RedditPage> {
        return withContext(DefaultDispatcherProvider.io()) {
            redditNetworkDataSource.fetchData(nameId, pageCount)
        }
    }
}