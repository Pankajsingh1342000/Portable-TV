package com.example.portabletv.reusable_composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.portabletv.data.remote.models.trending_tv_show_model.trendingTVShowsData

@Composable
fun TVShowPosterCard(
    poster: String,
    navController: NavController,
    adult: Boolean,
    name: String,
    original_language: String,
    original_name: String,
    overview: String,
    poster_path: String,
    popularity: String,
    first_air_date: String,
    vote_average: String,
    vote_count: String,

){
    Card (
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .height(237.dp)
            .clickable {
                navController.navigate(
                    "tv_show_detail_screen/${adult}/${name}/${original_language}/${original_name}/${overview}/${poster_path}/${popularity}/${first_air_date}/${vote_average}/${vote_count}"
                )
            },
    ) {
        AsyncImage(model = "https://image.tmdb.org/t/p/w500/${poster}", contentDescription = null)
    }
}

@Composable
fun MoviePosterCard(
    navController: NavController,
    adult: Boolean,
    title: String,
    original_language: String,
    original_title: String,
    overview: String,
    poster_path: String,
    popularity: String,
    release_date: String,
    vote_average: String,
    vote_count: String,
) {

    Card (
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .height(237.dp)
            .clickable {
                navController.navigate(
                    "movie_detail_screen/${adult}/${title}/${original_language}/${original_title}/${overview}/${poster_path}/${popularity}/${release_date}/${vote_average}/${vote_count}"
                )
            },
    ) {
        AsyncImage(model = "https://image.tmdb.org/t/p/w500/$poster_path", contentDescription = null)
    }
}

