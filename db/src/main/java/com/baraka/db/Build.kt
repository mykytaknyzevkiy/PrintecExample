package com.baraka.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.baraka.db.dao.NewsDao
import com.baraka.db.dao.TicketDao
import com.baraka.db.enitity.NewsEntity
import com.baraka.db.enitity.TicketEntity

object DBBuild {

    lateinit var ticketDao: TicketDao
    lateinit var newsDao: NewsDao

    fun build(applicationContext: Context) {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "baraka.db"
        ).build().also {
            ticketDao = it.ticketDao()
            newsDao = it.newsDao()
        }
    }

}

@Database(entities = [TicketEntity::class, NewsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDao

    abstract fun newsDao(): NewsDao
}