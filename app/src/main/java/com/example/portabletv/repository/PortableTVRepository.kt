package com.example.portabletv.repository

import com.example.portabletv.data.remote.TMDBAPIService
import com.example.portabletv.data.remote.models.trendingTVShowsData
import javax.inject.Inject

class PortableTVRepository @Inject constructor(private val tMDBAPIService: TMDBAPIService) {
    suspend fun getAllTrendingTVShows(): List<trendingTVShowsData> = tMDBAPIService.getTrendingTVShows().results
}