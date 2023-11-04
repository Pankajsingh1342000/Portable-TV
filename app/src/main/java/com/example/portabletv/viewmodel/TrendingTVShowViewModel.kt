package com.example.portabletv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portabletv.repository.TrendingTVShowsRepository
import com.example.portabletv.viewmodel.state.TrendingTVShowState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class TrendingTVShowViewModel @Inject constructor(private val trendingTVShowsRepository: TrendingTVShowsRepository): ViewModel() {
    private val _trendingTVShowState = MutableStateFlow<TrendingTVShowState>(TrendingTVShowState.Empty)
    val trendingTVShowState: StateFlow<TrendingTVShowState> = _trendingTVShowState

    init {
        getAllTrendingTVShows()
    }
    private fun getAllTrendingTVShows () {
        _trendingTVShowState.value = TrendingTVShowState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val trendingTVShowsResponse = trendingTVShowsRepository.getAllTrendingTVShows()
                _trendingTVShowState.value = TrendingTVShowState.Success(trendingTVShowsResponse)
            }
            catch (exception: HttpException) {
                _trendingTVShowState.value = TrendingTVShowState.Error("No Internet Connection")
            }
            catch (exception: IOException) {
                _trendingTVShowState.value = TrendingTVShowState.Error("Something Went Wrong")
            }
        }
    }
}