package com.printec_example.repository.convetor

import com.baraka.db.enitity.TicketEntity
import com.printec_example.network.response.TicketModel

fun TicketModel.toEntity() = TicketEntity(
    name = this.name,
    price = this.price
)

fun TicketEntity.toModel() = com.printec_example.repository.model.TicketModel(
    name = name,
    price = String.format("%.2f", price).toDouble()
)