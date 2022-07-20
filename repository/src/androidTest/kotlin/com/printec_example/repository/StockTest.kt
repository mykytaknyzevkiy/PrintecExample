package com.printec_example.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.printec_example.repository.repository.NewsRepository
import com.printec_example.repository.repository.StockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class StockTest {

    private lateinit var stockRepository: StockRepository
    private lateinit var newsRepository: NewsRepository

    @Before
    fun init() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        Build.init(appContext)

        stockRepository = StockRepository()
        newsRepository = NewsRepository()
    }

    @Test
    fun test(): Unit = runBlocking(Dispatchers.IO) {
        stockRepository.reload()

        newsRepository.reload()
    }


}