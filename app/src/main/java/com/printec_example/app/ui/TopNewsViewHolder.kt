package com.printec_example.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.printec_example.repository.model.NewsModel

@Composable
fun TopNewsViewHolder(newsModel: NewsModel) =
    Card(
        modifier = Modifier
            .padding(16.dp)
            .height(100.dp)
            .width(150.dp)
    ) {
        Column {
            Text(text = newsModel.title,
                Modifier
                    .padding(8.dp)
                    .weight(1f))

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                painter = rememberAsyncImagePainter(newsModel.urlToImage),
                contentDescription = null,
            )
        }
    }