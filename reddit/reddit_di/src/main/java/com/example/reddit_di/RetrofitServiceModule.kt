package com.example.reddit_di

import com.example.reddit_data.network_service.RedditPageApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitServiceModule = module {
    single<RedditPageApi> {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .baseUrl("https://reddit.com").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RedditPageApi::class.java)
    }
}