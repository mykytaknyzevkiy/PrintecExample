package com.baraka.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.baraka.db.enitity.NewsEntity
import com.baraka.db.enitity.TicketEntity

@Dao
interface NewsDao {

    @Insert
    suspend fun save(data: List<NewsEntity>)

    @Query("select * from news_n")
    @Transaction
    fun list(): PagingSource<Int, NewsEntity>

    @Query("delete from news_n")
    suspend fun removeAll()

    @Transaction
    suspend fun saveAll(data: List<NewsEntity>) {
        removeAll()
        save(data)
    }
}