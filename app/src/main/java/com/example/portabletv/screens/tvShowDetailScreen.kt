package com.example.portabletv.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun TVShowDescriptionCard(
    navController: NavController,
    adult: Boolean,
//    backdrop_path: String,
//    id: Int,
    name: String,
    original_language: String,
    original_name: String,
    overview: String,
    poster_path: String,
//    media_type: String,
//    genre_ids: List<Int>,
    popularity: String,
    first_air_date: String,
    vote_average: String,
    vote_count: String,
//    origin_country: List<String>
) {
    Card (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = overview)
        Text(text = name)
        Text(text = adult.toString())
        Text(text = poster_path)
        Text(text = original_language)
        Text(text = original_name)
        Text(text = popularity)
        Text(text = first_air_date)
        Text(text = vote_average)
        Text(text = vote_count)
    }
}