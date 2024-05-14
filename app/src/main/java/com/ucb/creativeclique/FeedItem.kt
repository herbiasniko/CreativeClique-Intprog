package com.ucb.creativeclique


data class FeedItem(
    val image1: Int,
    val username: String? = null,
    val followers: String? = null,
    val content: String? = null,
    val image2: Int
)
