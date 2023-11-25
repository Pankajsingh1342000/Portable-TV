package com.example.portabletv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.portabletv.screens.HomeScreen
import com.example.portabletv.screens.TVShowDescriptionCard
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
                    composable(
                        "tv_show_detail_screen/{adult}/{name}/{original_language}/{original_name}/{overview}/{poster_path}/{popularity}/{first_air_date}/{vote_average}/{vote_count}",
//                        "tv_show_detail_screen/{adult}/{backdrop_path}/{id}/{name}/{original_language}/{original_name}/{overview}/{poster_path}/{media_type}/{genre_ids}/{popularity}/{first_air_date}/{vote_average}/{vote_count}/{origin_country}",
                        arguments = listOf(
                            navArgument("adult") {
                                type = NavType.BoolType
                            },
//                            navArgument("backdrop_path") {
//                                type = NavType.StringType
//                            },
//                            navArgument("id") {
//                                type = NavType.IntType
//                            },
                            navArgument("name") {
                                type = NavType.StringType
                            },
                            navArgument("original_language") {
                                type = NavType.StringType
                            },
                            navArgument("original_name") {
                                type = NavType.StringType
                            },
                            navArgument("overview") {
                                type = NavType.StringType
                            },
                            navArgument("poster_path") {
                                type = NavType.StringType
                            },
//                            navArgument("media_type") {
//                                type = NavType.StringType
//                            },
//                            navArgument("genre_ids") {
//                                type = NavType.IntType
//                            },
                            navArgument("popularity") {
                                type = NavType.StringType
                            },
                            navArgument("first_air_date") {
                                type = NavType.StringType
                            },
                            navArgument("vote_average") {
                                type = NavType.StringType
                            },
                            navArgument("vote_count") {
                                type = NavType.StringType
                            },
//                            navArgument("origin_country") {
//                                type = NavType.StringArrayType
//                            },
                        )
                    ) {
                        val adult = remember {
                            it.arguments?.getBoolean("adult")
                        }
//                        val backdrop_path = remember {
//                            it.arguments?.getString("backdrop_path")
//                        }
//                        val id = remember {
//                            it.arguments?.getInt("id")
//                        }
                        val name = remember {
                            it.arguments?.getString("name")
                        }
                        val original_language = remember {
                            it.arguments?.getString("original_language")
                        }
                        val original_name = remember {
                            it.arguments?.getString("original_name")
                        }
                        val overview = remember {
                            it.arguments?.getString("overview")
                        }
                        val poster_path = remember {
                            it.arguments?.getString("poster_path")
                        }
//                        val media_type = remember {
//                            it.arguments?.getString("media_type")
//                        }
//                        val genre_ids = remember {
//                            it.arguments?.getIntegerArrayList("genre_ids")
//                        }
                        val popularity = remember {
                            it.arguments?.getString("popularity")
                        }
                        val first_air_date = remember {
                            it.arguments?.getString("first_air_date")
                        }
                        val vote_average = remember {
                            it.arguments?.getString("vote_average")
                        }
                        val vote_count = remember {
                            it.arguments?.getString("vote_count")
                        }
//                        val origin_country = remember {
//                            it.arguments?.getStringArrayList("origin_country")
//                        }

                        TVShowDescriptionCard(
                            navController = navController,
                            adult = adult!!,
//                            backdrop_path = backdrop_path!!,
//                            id = id!!,
                            name = name!!,
                            original_language = original_language!!,
                            original_name = original_name!!,
                            overview = overview!!,
                            poster_path = poster_path!!,
//                            media_type = media_type!!,
//                            genre_ids = genre_ids!!,
                            popularity = popularity!!,
                            first_air_date = first_air_date!!,
                            vote_average = vote_average!!,
                            vote_count = vote_count!!,
//                            origin_country = origin_country!!
                        )

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

