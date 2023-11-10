package com.example.portabletv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portabletv.repository.trendingMoviesRepository
import com.example.portabletv.repository.trendingTVShowRepository
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
class TrendingMoviesViewModel @Inject constructor(private val trendingMoviesRepository: trendingMoviesRepository): ViewModel() {
    private val _portableTVDataState = MutableStateFlow<PortableTVDataState>(PortableTVDataState.Empty)
    val portableTVDataState: StateFlow<PortableTVDataState> = _portableTVDataState

    init {
        getAllTrendingMovies()
    }
    private fun getAllTrendingMovies () {
        _portableTVDataState.value = PortableTVDataState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val trendingMoviesResponse = trendingMoviesRepository.getAllTrendingMovies()
                _portableTVDataState.value = PortableTVDataState.Success(trendingMoviesResponse)
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