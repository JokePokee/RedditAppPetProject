package com.example.reddit_di

import com.example.reddit_data.datasources.RedditNetworkDataSource
import com.example.reddit_data.datasources_implementations.RedditNetworkDataSourceImplementation
import com.example.reddit_data.repositories.RedditRepositoryImplementation
import com.example.reddit_domain.delegates.RedditPageLinkOpenerDelegate
import com.example.reddit_domain.repositories.RedditRepository
import com.example.reddit_domain.usecases.FetchDataUseCase
import com.example.reddit_presentation.delegates.ChromeTabOpenerDelegateImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { FetchDataUseCase(get()) }

    factory<RedditPageLinkOpenerDelegate> { ChromeTabOpenerDelegateImpl(androidContext()) }
    factory<RedditRepository> { RedditRepositoryImplementation(get()) }
    single<RedditNetworkDataSource> { RedditNetworkDataSourceImplementation(get()) }
}

