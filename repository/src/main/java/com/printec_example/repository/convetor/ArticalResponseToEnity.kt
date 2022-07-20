package com.printec_example.repository.convetor

import com.baraka.db.enitity.NewsEntity
import com.printec_example.network.response.ArticleModel
import com.printec_example.repository.model.NewsModel
import java.text.SimpleDateFormat
import java.util.*

fun ArticleModel.articleResponseToEntity() = NewsEntity(
    title = title,
    author = author ?: "No name",
    description = description,
    urlToImage = urlToImage,
    content = content,
    publishedAt = publishedAt
)

fun NewsEntity.toModel() = NewsModel(
    title = title,

    author = author,

    description = description,

    urlToImage = urlToImage,

    content = content,

    publishedAt = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.US).parse(
        publishedAt
    )!!
)