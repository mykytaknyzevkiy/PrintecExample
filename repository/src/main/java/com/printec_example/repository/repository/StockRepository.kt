package com.printec_example.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.baraka.db.DBBuild
import com.baraka.db.enitity.TicketEntity
import com.printec_example.network.Build
import com.printec_example.repository.convetor.toEntity
import com.printec_example.repository.convetor.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StockRepository {

    private val ticketDao by lazy {
        DBBuild.ticketDao
    }

    private val stockService by lazy {
        Build.stockService
    }

    suspend fun reload() {
        stockService.tickets().map {
            it.toEntity()
        }.also {
            ticketDao.saveAll(it)
        }
    }

    val tickets
        get() = Pager(
            config = PagingConfig(pageSize = 3),
            pagingSourceFactory = { ticketDao.list() },
        ).flow
            .map { p ->
                p.map { it.toModel() }
            }
}