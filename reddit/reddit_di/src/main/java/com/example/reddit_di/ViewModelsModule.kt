package com.example.reddit_di

import com.example.reddit_presentation.viewmodel.RedditSetupViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel{
        RedditSetupViewModel(get(),get())
    }
}