package com.example.portabletv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portabletv.repository.PortableTVRepository
import com.example.portabletv.viewmodel.state.PortableTVDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class TrendingTVShowViewModel @Inject constructor(private val portableTVRepository: PortableTVRepository): ViewModel() {
    private val _portableTVDataState = MutableStateFlow<PortableTVDataState>(PortableTVDataState.Empty)
    val portableTVDataState: StateFlow<PortableTVDataState> = _portableTVDataState

    init {
        getAllTrendingTVShows()
    }
    private fun getAllTrendingTVShows () {
        _portableTVDataState.value = PortableTVDataState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val trendingTVShowsResponse = portableTVRepository.getAllTrendingTVShows()
                _portableTVDataState.value = PortableTVDataState.Success(trendingTVShowsResponse)
            }
            catch (exception: HttpException) {
                _portableTVDataState.value = PortableTVDataState.Error("No Internet Connection")
            }
            catch (exception: IOException) {
                _portableTVDataState.value = PortableTVDataState.Error("Something Went Wrong")
            }
        }
    }
}