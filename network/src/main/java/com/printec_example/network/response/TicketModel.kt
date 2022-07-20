package com.printec_example.network.response

import com.google.gson.annotations.SerializedName

data class TicketModel(
    @SerializedName("STOCK")
    val name: String,
    @SerializedName(" PRICE")
    val price: Double
)
