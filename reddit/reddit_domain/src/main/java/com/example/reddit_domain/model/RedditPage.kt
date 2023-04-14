package com.example.reddit_domain.model

data class RedditPage(

    var title: String,
    var author: String,
    var subreddit: String,
    var thumbnail: String,
    var currentRating: Int,
    var numberOfComments: Int,
    var postDate: Long,
    var permalink: String,
    var name: String
)
