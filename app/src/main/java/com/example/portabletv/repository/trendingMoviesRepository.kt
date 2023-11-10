package com.example.portabletv.repository

import com.example.portabletv.data.remote.TMDBAPIService
import com.example.portabletv.data.remote.models.trending_movies_model.trendingMoviesData
import com.example.portabletv.data.remote.models.trending_tv_show_model.trendingTVShowsData
import javax.inject.Inject

class trendingMoviesRepository @Inject constructor(private val tMDBAPIService: TMDBAPIService) {
    suspend fun getAllTrendingMovies(): List<trendingMoviesData> = tMDBAPIService.getTrendingMovies().results
}