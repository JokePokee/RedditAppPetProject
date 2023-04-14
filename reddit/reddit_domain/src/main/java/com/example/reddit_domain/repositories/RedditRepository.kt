package com.example.reddit_domain.repositories

import com.example.reddit_domain.model.RedditPage

interface RedditRepository {

    suspend fun fetchData(nameId: String? = null, pageCount: Int)

}