package com.baraka.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.baraka.db.enitity.TicketEntity

@Dao
interface TicketDao {

    @Insert
    suspend fun save(data: List<TicketEntity>)

    @Query("delete from tickets")
    suspend fun removeAll()

    @Transaction
    suspend fun saveAll(data: List<TicketEntity>) {
        removeAll()
        save(data)
    }

    @Query("select * from tickets")
    @Transaction
    fun list(): PagingSource<Int, TicketEntity>

}