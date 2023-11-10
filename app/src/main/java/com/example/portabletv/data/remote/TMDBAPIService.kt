package com.example.portabletv.data.remote

import com.example.portabletv.data.remote.models.trending_movies_model.TrendingMoviesResponse
import com.example.portabletv.utils.GET_TENDING_TV_SHOWS
import com.example.portabletv.data.remote.models.trending_tv_show_model.TrendingTVShowsResponse
import com.example.portabletv.utils.GET_TENDING_MOVIES
import retrofit2.http.GET

interface TMDBAPIService {

    @GET(GET_TENDING_TV_SHOWS)
    suspend fun getTrendingTVShows(): TrendingTVShowsResponse

    @GET(GET_TENDING_MOVIES)
    suspend fun getTrendingMovies(): TrendingMoviesResponse

}