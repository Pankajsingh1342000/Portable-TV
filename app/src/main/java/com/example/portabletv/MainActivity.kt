package com.example.portabletv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portabletv.screens.HomeScreen
import com.example.portabletv.ui.theme.PortableTVTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortableTVTheme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home_screen"
                ) {
                    composable("home_screen") {
                        HomeScreen(navController = navController)
                    }
                }

//                HomeScreen(navController)

//                Column (modifier = Modifier
//                    .padding(10.dp)
//                ) {
//                    HomeScreen(navController)
//                }


            }
        }
    }
}

