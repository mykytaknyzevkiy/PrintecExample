package com.baraka.db.enitity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_n")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val title: String,

    val author: String,

    val description: String,

    val urlToImage: String,

    val content: String,

    val publishedAt: String
)
