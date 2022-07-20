package com.printec_example.app.screen

import androidx.lifecycle.viewModelScope
import com.printec_example.app.unit.GlobalViewModel
import com.printec_example.app.unit.MState
import com.printec_example.repository.repository.NewsRepository
import com.printec_example.repository.repository.StockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel : GlobalViewModel() {

    private val stockRepository = StockRepository()

    private val newsRepository = NewsRepository()

    private val _state = MutableStateFlow<MState>(MState.Empty)
    val state: StateFlow<MState>
        get() = _state

    val tickets = stockRepository
        .tickets
        .onStart {
            _state.value = MState.LoadingState

            try {
                stockRepository.reload()
            } catch (e: Exception) {
                processError(e)
            }

            _state.value = MState.Empty
        }

    val news = newsRepository
        .list
        .onStart {
            _state.value = MState.LoadingState

            try {
                newsRepository.reload()
            } catch (e: Exception) {
                processError(e)
            }

            _state.value = MState.Empty
        }

    fun reloadFull() = viewModelScope.launch(Dispatchers.IO) {
        _state.value = MState.LoadingState

        try {
            stockRepository.reload()

            newsRepository.reload()
        } catch (e: Exception) {
            processError(e)
        }

        _state.value = MState.Empty
    }

}