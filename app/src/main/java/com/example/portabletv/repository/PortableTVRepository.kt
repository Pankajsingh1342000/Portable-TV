package com.example.portabletv.repository

import com.example.portabletv.data.remote.TMDBAPIService
import com.example.portabletv.data.remote.models.trending_tv_show_model.trendingTVShowsData
import javax.inject.Inject

class PortableTVRepository @Inject constructor(private val tMDBAPIService: TMDBAPIService) {
    suspend fun getAllTrendingTVShows(): List<trendingTVShowsData> = tMDBAPIService.getTrendingTVShows().results
}