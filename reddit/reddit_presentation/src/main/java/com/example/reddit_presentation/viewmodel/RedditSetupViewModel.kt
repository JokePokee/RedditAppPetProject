package com.example.reddit_presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reddit_domain.dispatcher.DefaultDispatcherProvider
import com.example.reddit_domain.dispatcher.DispatcherProvider
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_domain.repositories.RedditRepository
import com.example.reddit_domain.usecases.FetchDataUseCase
import kotlinx.coroutines.Dispatchers

class RedditSetupViewModel(
    private val fetchDataUseCase: FetchDataUseCase,
    private val redditRepository: RedditRepository,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _redditLiveData = MutableLiveData<RedditPage>()

    val redditLiveData: LiveData<RedditPage> = _redditLiveData

    fun getPageData(){

    }
}