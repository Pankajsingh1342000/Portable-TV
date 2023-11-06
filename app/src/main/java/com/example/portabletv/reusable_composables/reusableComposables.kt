package com.example.portabletv.reusable_composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PosterCard(posterPath : String) {
    Card (
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .height(237.dp)
    ){
        AsyncImage(model = "https://image.tmdb.org/t/p/w500/$posterPath", contentDescription = null)
    }
}