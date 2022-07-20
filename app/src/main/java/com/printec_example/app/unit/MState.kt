package com.printec_example.app.unit

sealed class MState {
    object LoadingState: MState()

    sealed class MError: MState() {
        object NoInternet: MError()

        object UnFound: MError()

        object Empty: MError()
    }

    object Empty: MState()
}
