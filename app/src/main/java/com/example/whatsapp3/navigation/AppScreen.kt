package com.example.pantallas.navegacion

/**
 * Clase sellada que representa las pantallas disponibles en la navegación de la aplicación.
 * Cada objeto dentro de esta clase define una pantalla específica con su ruta correspondiente.
 *
 * - [HomeScreen]: Pantalla de inicio.
 * - [ChatScreen]: Pantalla de chat, donde se pasa un argumento de tipo String para identificar el chat.
 *
 * @property route La ruta asociada a cada pantalla, que se utiliza para la navegación en el sistema de rutas.
 */
sealed class AppScreen (val route: String) {

    /**
     * Pantalla de inicio, que muestra una lista de contactos o chats.
     */
    object HomeScreen: AppScreen("HomeScreen")

    /**
     * Pantalla de chat, que permite ver y enviar mensajes a un contacto específico.
     * Recibe un argumento en la ruta para identificar el nombre del contacto.
     */
    object ChatScreen: AppScreen("ChatScreen")
}