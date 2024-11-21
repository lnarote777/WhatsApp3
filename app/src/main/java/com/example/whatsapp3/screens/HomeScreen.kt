package com.example.pantallas.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pantallas.navegacion.AppScreen
import com.example.whatsapp3.R

data class Contact(val name: String, val msj: String)

private val contactos = listOf(
    Contact("Juan", "Hola tio"),
    Contact("Antonio", "Cuando quedamos?"),
    Contact("Marcos", "Adios"),
    Contact("Pedro", "Tia, pasame la tarea"),
    Contact("Luis", "porfaaa"),
    Contact("Lucia", "chaoo"),
    Contact("ZeZar", "AAAAAAAAAAAAAAA"),
    Contact("Carmen", "te veo luego"),
    Contact("Silvia", "lo he dejado con fernando ;-;"),
    Contact("Paco", "Play?"),
    Contact("Alberto", "XD"),
    Contact("Julia", "Alfinal suspendí jsjajasja"),
    Contact("Carmen 2", "mañana quedo con esta gente"),
    Contact("Luis Clase", "Holap"),
    Contact("Maria Cuñada", "Gordita nos vemos mañana"),
    Contact("Juanma", "Mañana a las 10:00"),
    Contact("Juan2", "p")



)

@Composable
fun HomeScreen(navController: NavController){
    HomeBody(navController = navController)
}



@Composable
fun HomeBody(navController: NavController){
    Column (modifier = Modifier.fillMaxSize().padding(top = 30.dp, bottom = 16.dp)){
        HeaderHome()

        Listado(navController)
    }
}

@Composable
fun HeaderHome(){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = colorResource(R.color.headerWa))
            .fillMaxWidth()
            .height(65.dp)

    ) {
        Text(
            modifier = Modifier.padding(horizontal = 15.dp),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.inicio),
            fontSize = 30.sp,
            color = colorResource(R.color.white),
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.weight(1f))

        Image(painter = painterResource(R.drawable.camera),
            contentDescription = "Camara",
            modifier = Modifier.size(30.dp)
        )

        Spacer(Modifier.width(10.dp))

        Icon(imageVector = Icons.Default.Search,
            contentDescription = "Buscar",
            tint = colorResource(R.color.white),
            modifier = Modifier.size(30.dp)
        )

        Spacer(Modifier.width(10.dp))

        Icon( imageVector = Icons.Filled.MoreVert,
            contentDescription = "Ver más",
            tint = colorResource(R.color.white),
            modifier = Modifier.size(30.dp)
        )

    }
}

@Composable
fun Listado(navController: NavController){
    LazyColumn (
        userScrollEnabled = true,
    ){
        items(contactos.size){
            Chat(contactos[it], navController = navController )
        }
    }
}

@Composable
fun Chat(contacto: Contact, navController: NavController){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .clickable { navController.navigate(route = AppScreen.ChatScreen.route + "/${contacto.name}") }
            .background(color = colorResource(R.color.bodyHomeWa))
    ) {
        Icon(imageVector = Icons.Default.AccountCircle,
            contentDescription = contacto.name,
            modifier = Modifier.size(60.dp),
            tint = colorResource(R.color.sinFoto)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Text(
                text = contacto.name,
                fontSize = 20.sp,
                color = Color.White
            )

            Text(
                text = contacto.msj,
                fontSize = 15.sp,
                color = Color.White
            )

        }

    }
}
