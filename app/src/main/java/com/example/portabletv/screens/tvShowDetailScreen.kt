package com.example.portabletv.screens

import android.media.Rating
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun TVShowDescriptionCard(
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
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(ScrollState(1), true, null, false)
    ) {
        TopBar(title = name)
        Poster(poster_path = poster_path)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Overview", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Overview(overview)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Air Date", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        AirDate(first_air_date = first_air_date)
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
        OriginalName(original_name = original_name)
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

@Composable
fun TopBar (
    title: String
) {
    Text(
        text = title,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun Poster(poster_path: String) {

    Card (modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/original/$poster_path",
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
        )
    }

}

@Composable
fun Overview (overview: String) {
    Box(modifier = Modifier) {
        Text(text = overview, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun AirDate (first_air_date: String) {
    Box(modifier = Modifier) {
        Text(text = first_air_date, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun Popularity (popularity: String) {
    Box(modifier = Modifier) {
        Text(text = popularity, style = MaterialTheme.typography.bodyLarge)
    }
}
@Composable
fun Rating(vote_average: String) {
    Box(modifier = Modifier) {
        Text(text = vote_average, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun VoteCount(vote_count: String) {
    Box(modifier = Modifier) {
        Text(text = vote_count, style = MaterialTheme.typography.bodyLarge)
    }
}
@Composable
fun OriginalName(original_name: String) {
    Box(modifier = Modifier) {
        Text(text = original_name, style = MaterialTheme.typography.bodyLarge)
    }
}
@Composable
fun OriginalLanguage(original_language: String) {
    Box(modifier = Modifier) {
        Text(text = original_language.uppercase(), style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun AdultRating(adult: Boolean) {
    Box(modifier = Modifier) {
        if (adult) {
            Text(text = "18+", style = MaterialTheme.typography.bodyLarge)
        }
        else{
            Text(text = "16+", style = MaterialTheme.typography.bodyLarge)
        }
    }
}