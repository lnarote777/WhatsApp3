package com.example.pantallas.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.whatsapp3.screens.ChatScreen
import com.example.pantallas.screens.HomeScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.HomeScreen.route){
        composable(AppScreen.HomeScreen.route){
            HomeScreen(navController)
        }

        composable(AppScreen.ChatScreen.route+ "/{text}",
            arguments = listOf(navArgument(name = "text"){
                type = NavType.StringType
            })
        ){
            ChatScreen(navController, it.arguments?.getString("text"))
        }
    }
}
