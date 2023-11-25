package com.example.portabletv.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MovieDescriptionCard(
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
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(ScrollState(1), true, null, false)
    ) {
        TopBar(title = title)
        Poster(poster_path = poster_path)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Overview", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Overview(overview)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Air Date", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        AirDate(first_air_date = release_date)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Popularity", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Popularity(popularity = popularity)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Rating", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Rating(vote_average = vote_average)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Vote Count", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        VoteCount(vote_count = vote_count)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Original Name", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OriginalName(original_name = original_title)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Original Language", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OriginalLanguage(original_language = original_language)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "PG Rating", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        AdultRating(adult = adult)
    }
}