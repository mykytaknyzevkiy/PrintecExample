package com.printec_example.network

import android.content.Context
import android.content.SharedPreferences
import com.printec_example.network.cvs.CsvConverterFactory
import com.printec_example.network.service.NewsService
import com.printec_example.network.service.StockService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Build {

    lateinit var stockService: StockService
    lateinit var newsService: NewsService

    const val stockUrl = "raw.githubusercontent.com/dsancov/TestData/main"
    const val cnnUrl = "saurav.tech/NewsAPI/everything"

    fun init(context: Context) {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }).build()

        Retrofit.Builder()
            .client(client)
            .addConverterFactory(CsvConverterFactory.create())
            .baseUrl("https://$stockUrl/")
            .build().also {
                stockService = it.create(StockService::class.java)
            }

        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://$cnnUrl/")
            .build().also {
                newsService = it.create(NewsService::class.java)
            }
    }

}