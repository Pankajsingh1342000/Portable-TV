package com.example.portabletv.data.remote

import com.example.portabletv.data.remote.models.trending_movies_model.TrendingMoviesResponse
import com.example.portabletv.utils.GET_TENDING_TV_SHOWS
import com.example.portabletv.data.remote.models.trending_tv_show_model.TrendingTVShowsResponse
import com.example.portabletv.utils.API_KEY
import com.example.portabletv.utils.GET_TENDING_MOVIES
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBAPIService {

    @GET(GET_TENDING_TV_SHOWS)
    suspend fun getTrendingTVShows(
        @Query("api_key") api_key: String = API_KEY
    ): TrendingTVShowsResponse

    @GET(GET_TENDING_MOVIES)
    suspend fun getTrendingMovies(
        @Query("api_key") api_key: String = API_KEY
    ): TrendingMoviesResponse

}