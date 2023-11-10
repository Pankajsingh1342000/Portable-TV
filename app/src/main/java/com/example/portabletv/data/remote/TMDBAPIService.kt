package com.example.portabletv.data.remote

import com.example.portabletv.utils.GET_TENDING_TV_SHOWS
import com.example.portabletv.data.remote.models.trending_tv_show_model.TrendingTVShowsResponse
import retrofit2.http.GET

interface TMDBAPIService {

    @GET(GET_TENDING_TV_SHOWS)
    suspend fun getTrendingTVShows(): TrendingTVShowsResponse

}