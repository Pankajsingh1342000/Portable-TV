package com.example.portabletv.viewmodel.state

import com.example.portabletv.data.remote.models.trendingTVShowsData

sealed class TrendingTVShowState {
    object Empty: TrendingTVShowState()
    object Loading: TrendingTVShowState()
    class Success(val data: List<trendingTVShowsData>): TrendingTVShowState()
    class Error(val message: String): TrendingTVShowState()
}
