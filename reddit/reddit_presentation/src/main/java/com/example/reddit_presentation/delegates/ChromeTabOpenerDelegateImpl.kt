package com.example.reddit_presentation.delegates

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.browser.customtabs.CustomTabsIntent
import com.example.reddit_domain.delegates.RedditPageLinkOpenerDelegate

class ChromeTabOpenerDelegateImpl(private val context: Context) : RedditPageLinkOpenerDelegate {

    override fun openRedditPage(link: String) {
        val url = "https://reddit.com$link"

        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(
            ContextCompat.getColor(
                context,
                com.google.android.material.R.color.design_default_color_primary
            )
        )
        builder.addDefaultShareMenuItem()

        val customTabsIntent = builder.build()
        customTabsIntent.intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        customTabsIntent.launchUrl(context, Uri.parse(url))
    }

}