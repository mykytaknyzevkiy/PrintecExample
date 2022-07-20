package com.printec_example.network

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.printec_example.network.service.NewsService
import com.printec_example.network.service.StockService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FinanceTest {

    private lateinit var stockService: StockService
    private lateinit var newsService: NewsService

    @Test
    fun readTickets(): Unit = runBlocking(Dispatchers.IO) {
        val response = stockService.tickets()

        println(response)

        assert(response.isNotEmpty())
    }
}