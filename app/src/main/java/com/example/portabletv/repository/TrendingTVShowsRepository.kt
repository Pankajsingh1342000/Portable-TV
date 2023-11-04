package com.example.portabletv.repository

import com.example.portabletv.data.remote.TrendingTVShowsAPIService
import com.example.portabletv.data.remote.models.trendingTVShowsData
import javax.inject.Inject

class TrendingTVShowsRepository @Inject constructor(private val trendingTVShowsAPIService: TrendingTVShowsAPIService) {
    suspend fun getAllTrendingTVShows(): List<trendingTVShowsData> = trendingTVShowsAPIService.getTrendingTVShows().results
}