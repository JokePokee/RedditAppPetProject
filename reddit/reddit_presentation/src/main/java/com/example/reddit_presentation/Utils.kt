package com.example.reddit_presentation

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.reddit_domain.model.RedditPage
import java.time.Duration
import java.time.Instant

@RequiresApi(Build.VERSION_CODES.S)
fun RedditPage.findPostCreated(postDate: Long): String{
    val diff: Duration =
        Duration.between(Instant.ofEpochMilli(postDate * 1000L), Instant.now())

    return when {
        diff.toMinutes() < 1L -> "posted ${diff.toSeconds()} seconds ago"
        diff.toHours() < 1L -> "posted ${diff.toMinutes()} minutes ago"
        diff.toDays() < 1L -> "posted ${diff.toHours()} hours ago"
        else -> "posted ${diff.toDays()} days ago"
    }
}