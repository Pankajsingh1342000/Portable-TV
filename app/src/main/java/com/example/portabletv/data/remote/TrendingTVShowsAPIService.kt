package com.example.portabletv.data.remote

import com.example.portabletv.utils.GET_TENDING_TV_SHOWS
import com.example.portabletv.data.remote.models.TrendingTVShowsResponse
import retrofit2.http.GET

interface TrendingTVShowsAPIService {

    @GET(GET_TENDING_TV_SHOWS)
    suspend fun getTrendingTVShows(): TrendingTVShowsResponse
}