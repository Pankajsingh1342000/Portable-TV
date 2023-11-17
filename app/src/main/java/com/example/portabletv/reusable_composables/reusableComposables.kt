package com.example.portabletv.reusable_composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PosterCard(posterPath : String, overview: String){
    var isDescriptionVisible by remember { mutableStateOf(false) }
    Card (
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .height(237.dp)
            .clickable { isDescriptionVisible = true },
    ){
        AsyncImage(model = "https://image.tmdb.org/t/p/w500/$posterPath", contentDescription = null)
    }
    if (isDescriptionVisible) {
        DescriptionCard(overview = overview) {
            isDescriptionVisible = false
        }
    }
}

@Composable
fun DescriptionCard(overview: String, onCloseClick: () -> Unit) {
    Card (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = overview)
    }
}