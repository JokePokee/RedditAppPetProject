package com.example.reddit_data.repositories

import com.example.reddit_data.datasources.RedditPageApi
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_domain.repositories.RedditRepository

class RedditRepositoryImplementation(private val redditPageApi: RedditPageApi):RedditRepository {




    override suspend fun fetchData(nameId: String?, pageCount: Int) {
        redditPageApi.getDataFromPage()
    }
}