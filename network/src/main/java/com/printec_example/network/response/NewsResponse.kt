package com.printec_example.network.response

data class NewsResponse(
    val totalResults: Int,
    val articles: List<ArticleModel>
)

data class ArticleModel(
    val author: String? = null,
    val title: String,
    val description: String,
    val urlToImage: String,
    val content: String,
    val publishedAt: String
)
