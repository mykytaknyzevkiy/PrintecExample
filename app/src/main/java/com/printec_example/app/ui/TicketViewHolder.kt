package com.printec_example.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.printec_example.repository.model.TicketModel

@Composable
fun TicketViewHolder(ticketModel: TicketModel) = Card(modifier = Modifier.padding(PaddingValues(16.dp))) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "${ticketModel.name} USD")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = ticketModel.price.toString())
    }
}