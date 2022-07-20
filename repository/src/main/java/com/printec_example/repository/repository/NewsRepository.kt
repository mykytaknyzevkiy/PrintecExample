package com.printec_example.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.baraka.db.DBBuild
import com.printec_example.network.Build
import com.printec_example.repository.convetor.articleResponseToEntity
import com.printec_example.repository.convetor.toModel
import kotlinx.coroutines.flow.map

class NewsRepository {

    private val newsDao by lazy {
        DBBuild.newsDao
    }

    private val newsService by lazy {
        Build.newsService
    }

    suspend fun reload() {
        newsService.news().articles.map {
            it.articleResponseToEntity()
        }.also {
            newsDao.saveAll(it)
        }
    }

    val list
        get() = Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { newsDao.list() }
        ).flow
            .map { p ->
                p.map {
                    it.toModel()
                }
            }

}