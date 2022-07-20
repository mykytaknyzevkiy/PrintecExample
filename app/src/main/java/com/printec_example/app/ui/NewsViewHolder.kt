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
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun NewsViewHolder(newsModel: NewsModel) = Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            painter = rememberAsyncImagePainter(newsModel.urlToImage),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = newsModel.title)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = newsModel.description)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = newsModel.content)

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = newsModel.author)

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = SimpleDateFormat(
                    "yyyy-MM-dd hh:mm",
                    Locale.US
                ).format(newsModel.publishedAt)
            )
        }
    }
}