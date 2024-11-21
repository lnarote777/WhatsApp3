package com.example.pantallas.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.whatsapp3.screens.ChatScreen
import com.example.pantallas.screens.HomeScreen

/**
 * Configura la navegación de la aplicación utilizando [NavController] y [NavHost].
 * Este componente gestiona las pantallas de la aplicación y los argumentos entre ellas.
 *
 * - Pantalla de inicio: [HomeScreen].
 * - Pantalla de chat: [ChatScreen], que recibe un argumento de tipo String (el nombre del contacto).
 *
 * @see NavController
 * @see NavHost
 * @see HomeScreen
 * @see ChatScreen
 */
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
