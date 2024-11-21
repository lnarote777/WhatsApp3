package com.example.pantallas.navegacion

sealed class AppScreen (val route: String) {
    object HomeScreen: AppScreen("HomeScreen")
    object ChatScreen: AppScreen("ChatScreen")
}