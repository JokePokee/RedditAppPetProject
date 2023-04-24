package com.example.reddit_presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reddit_domain.dispatcher.DefaultDispatcherProvider
import com.example.reddit_domain.dispatcher.DispatcherProvider
import com.example.reddit_domain.model.RedditPage
import com.example.reddit_domain.repositories.RedditRepository
import com.example.reddit_domain.usecases.FetchDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RedditSetupViewModel(
    private val fetchDataUseCase: FetchDataUseCase
) : ViewModel() {

    var redditLiveData = MutableLiveData<List<RedditPage>>()
    var isLoading = false
    init {
        viewModelScope.launch {
            isLoading = true
            redditLiveData.value = fetchDataUseCase.execute()
            isLoading = false
        }
    }

    fun onPagination() {
        if (isLoading.not()) {
            viewModelScope.launch {
                isLoading = true
                val currentList = redditLiveData.value ?: emptyList()
                redditLiveData.value = if (currentList.isNotEmpty()) {
                    currentList + fetchDataUseCase.execute(currentList.last().name)
                } else {
                    fetchDataUseCase.execute()
                }
                isLoading = false
            }
        }
    }

}