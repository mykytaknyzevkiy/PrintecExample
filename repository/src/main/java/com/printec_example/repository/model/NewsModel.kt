package com.printec_example.repository.model

import java.util.*

data class NewsModel(
    val title: String,

    val author: String,

    val description: String,

    val urlToImage: String,

    val content: String,

    val publishedAt: Date
)
