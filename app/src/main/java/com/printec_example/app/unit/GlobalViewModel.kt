package com.printec_example.app.unit

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.net.UnknownHostException

/*
GlobalViewModel is base viewmodel for basically functions such as error handler
 */
abstract class GlobalViewModel : ViewModel() {
    private val _errorState = MutableStateFlow<MState.MError>(MState.MError.Empty)
    val errorState: StateFlow<MState.MError>
        get() = _errorState

    fun clearError() {
        _errorState.value = MState.MError.Empty
    }

    protected fun processError(e: Exception) {
        if (e is UnknownHostException)
            _errorState.value = MState.MError.NoInternet
        else
            _errorState.value = MState.MError.UnFound

        e.printStackTrace()
    }
}