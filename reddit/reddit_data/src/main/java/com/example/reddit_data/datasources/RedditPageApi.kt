package com.example.reddit_data.datasources

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditPageApi {

    @GET("/top.json?limit=10")
    suspend fun getDataFromPage(): JsonObject
    @GET("/top.json?")
    suspend fun getPaginationData(@Query("limit") limit: Int = 10, @Query("after") name: String):JsonObject


}