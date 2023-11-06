package com.example.portabletv.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.portabletv.R
import com.example.portabletv.data.remote.models.trendingTVShowsData
import com.example.portabletv.viewmodel.TrendingTVShowViewModel
import com.example.portabletv.viewmodel.state.PortableTVDataState

@Composable
fun HomeScreen() {
    Column {
        TopAppBar()
        FetchTrendingTVShowData()
    }
}

@Composable
fun FetchTrendingTVShowData(trendingTVShowViewModel: TrendingTVShowViewModel = viewModel()) {
    Column {
        when(val state = trendingTVShowViewModel.portableTVDataState.collectAsState().value) {
            is PortableTVDataState.Empty -> Text(text = "No Data Available")
            is PortableTVDataState.Loading -> Text(text = "Loading...")
            is PortableTVDataState.Success -> TrendingTVShowPosterList(trendingTVShowsData = state.data as List<trendingTVShowsData>)
            is PortableTVDataState.Error -> Text(text = state.message)
        }
    }
}

@Composable
fun TrendingTVShowPosterList(trendingTVShowsData: List<trendingTVShowsData>) {
    Column {
        LazyRow (
            content = {
                items(trendingTVShowsData) {
                    TrendingTVShowPosterCard(posterPath = it.poster_path)
                }
            }
        )
    }
}

@Composable
fun TrendingTVShowPosterCard(posterPath : String) {
    Card {
        AsyncImage(model = "https://image.tmdb.org/t/p/original/$posterPath", contentDescription = null)
    }
}

@Composable
fun TopAppBar() {
    Row (modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Refresh,
                contentDescription = "Refresh Icon"
            )
        }
        Text(
            text = (stringResource(id = R.string.app_name)),
            style = MaterialTheme.typography.headlineMedium
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.icon_moon),
                contentDescription = "Dark/Light Icon"
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}