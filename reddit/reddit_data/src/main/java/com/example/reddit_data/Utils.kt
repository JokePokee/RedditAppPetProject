package com.example.reddit_data

import com.example.reddit_domain.model.RedditPage
import com.google.gson.JsonObject

fun JsonObject.toRedditPageList(): List<RedditPage> {
    val firstData = this["data"].asJsonObject
    val children = firstData["children"].asJsonArray
    val item0 = children[0].asJsonObject
    val data2 = item0["data"].asJsonObject
    val title = data2["title"].toString()

    return children.map {

        val data = it.asJsonObject["data"].asJsonObject

        val spisok = RedditPage(
            title = data["title"].asString,
            author = data["author"].asString,
            subreddit = data["subreddit"].asString,
            thumbnail = data["thumbnail"].asString,
            currentRating = data["ups"].asInt,
            numberOfComments = data["num_comments"].asInt,
            postDate = data["created_utc"].asLong,
            permalink = data["permalink"].asString,
            name = data["name"].asString
        )
        spisok
    }
}