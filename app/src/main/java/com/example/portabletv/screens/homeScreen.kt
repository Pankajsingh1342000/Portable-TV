package com.example.portabletv.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.portabletv.R
import com.example.portabletv.data.remote.models.trending_movies_model.trendingMoviesData
import com.example.portabletv.data.remote.models.trending_tv_show_model.trendingTVShowsData
import com.example.portabletv.reusable_composables.PosterCard
import com.example.portabletv.viewmodel.TrendingMoviesViewModel
import com.example.portabletv.viewmodel.TrendingTVShowViewModel
import com.example.portabletv.viewmodel.state.PortableTVDataState

@Composable
fun HomeScreen(navController: NavController) {
    Surface (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            TopAppBar()
            SearchBar(
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

            }
            FetchTrendingTVShowData(navController)
            FetchTrendingMoviesData(navController)
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch : (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "",)
    }

    Box (
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(color = Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true
                },
        )
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
fun FetchTrendingMoviesData(navController: NavController,trendingMoviesViewModel: TrendingMoviesViewModel = hiltViewModel()) {
    Column {
        when(val state = trendingMoviesViewModel.portableTVDataState.collectAsState().value) {
            is PortableTVDataState.Empty -> Text(text = "No Data Available")
            is PortableTVDataState.Loading -> Text(text = "Loading...")
            is PortableTVDataState.Success -> TrendingMoviesPosterList(trendingMoviesData = state.data as List<trendingMoviesData>)
            is PortableTVDataState.Error -> Text(text = state.message)
        }
    }
}


@Composable
fun FetchTrendingTVShowData(navController: NavController,trendingTVShowViewModel: TrendingTVShowViewModel = hiltViewModel()) {
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
fun TrendingMoviesPosterList(trendingMoviesData: List<trendingMoviesData>) {

    Column {
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            text = "Trending Movies"
        )
        if(trendingMoviesData.isEmpty()){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "NO DATA"
                )
                Text(
                    text = "NO DATA AVAILABLE",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        else {
            LazyRow (
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentSize(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                content = {
                    items(trendingMoviesData) {
                        PosterCard(posterPath = it.poster_path, overview = it.overview)
                    }
                }
            )
        }
    }
}

@Composable
fun TrendingTVShowPosterList(trendingTVShowsData: List<trendingTVShowsData>) {
    Column {
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            text = "Trending TV Show"
        )
        if(trendingTVShowsData.isEmpty()){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "NO DATA"
                )
                Text(
                    text = "NO DATA AVAILABLE",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        else {
            LazyRow (
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentSize(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                content = {
                    items(trendingTVShowsData) {
                        PosterCard(posterPath = it.poster_path, overview = it.overview)

                    }
                }
            )
        }
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

//@Preview
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}