package com.printec_example.network.service

import com.printec_example.network.response.NewsResponse
import retrofit2.http.GET

interface NewsService {
    @GET("cnn.json")
    suspend fun news(): NewsResponse
}
