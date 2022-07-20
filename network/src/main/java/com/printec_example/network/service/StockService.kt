package com.printec_example.network.service

import com.printec_example.network.response.TicketModel
import retrofit2.http.GET

interface StockService {

    @GET("stocks.csv")
    suspend fun tickets(): List<TicketModel>

}