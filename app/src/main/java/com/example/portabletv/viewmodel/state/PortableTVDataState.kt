package com.example.portabletv.viewmodel.state

sealed class PortableTVDataState {
    object Empty: PortableTVDataState()
    object Loading: PortableTVDataState()
    class Success(val data: List<Any?>): PortableTVDataState()
    class Error(val message: String): PortableTVDataState()
}
