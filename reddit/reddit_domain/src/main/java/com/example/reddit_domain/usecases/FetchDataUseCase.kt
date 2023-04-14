package com.example.reddit_domain.usecases

import com.example.reddit_domain.model.RedditPage
import com.example.reddit_domain.repositories.RedditRepository

class FetchDataUseCase(private val redditRepository: RedditRepository) {

    suspend fun execute(nameId: String? = null) {
        redditRepository.fetchData(nameId, PAGE_SIZE)
    }

    companion object {
        private const val PAGE_SIZE = 10
    }
}