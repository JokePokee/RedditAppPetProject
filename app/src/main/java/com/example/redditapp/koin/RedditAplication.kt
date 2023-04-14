package com.example.redditapp.koin

import android.app.Application
import com.example.reddit_di.appModule
import com.example.reddit_di.retrofitServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class RedditAplication: Application(), KoinComponent {

    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RedditAplication)
            workManagerFactory()
            modules(
                retrofitServiceModule,
                appModule
            )
        }

    }
}