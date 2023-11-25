package com.example.portabletv.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MovieDescriptionCard(
    navController: NavController,
    adult: Boolean,
    backdrop_path: String,
    id: Int,
    name: String,
    original_language: String,
    original_name: String,
    overview: String,
    poster_path: String,
    media_type: String,
    genre_ids: List<Int>,
    popularity: Double,
    first_air_date: String,
    vote_average: Double,
    vote_count: Int,
    origin_country: List<String>
) {
    Card (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = overview)
    }
}