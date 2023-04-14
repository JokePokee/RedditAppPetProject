package com.example.reddit_domain.repositories

import com.example.reddit_domain.model.RedditPage

interface RedditRepository {

    suspend fun firstFetchData()

    suspend fun paginationFetchData(redditPage: RedditPage)
}