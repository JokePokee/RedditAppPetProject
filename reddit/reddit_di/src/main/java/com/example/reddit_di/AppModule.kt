package com.example.reddit_di

import com.example.reddit_data.datasources.RedditPageApi
import com.example.reddit_data.repositories.RedditRepositoryImplementation
import com.example.reddit_domain.repositories.RedditRepository
import com.example.reddit_domain.usecases.FetchDataUseCase
import org.koin.dsl.module

val appModule = module {
    factory { FetchDataUseCase(get()) }

    factory<RedditRepository> { RedditRepositoryImplementation(get()) }
}

