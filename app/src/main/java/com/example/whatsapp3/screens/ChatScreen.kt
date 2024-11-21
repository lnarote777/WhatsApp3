package com.example.whatsapp3.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pantallas.navegacion.AppScreen
import com.example.whatsapp3.R
import kotlin.math.absoluteValue


val mensaje = mutableStateOf("")
var chats = mutableStateListOf<String>()

@Composable
fun ChatScreen(navController: NavController, contactName: String?){
    ChatBody(navController = navController, contactName)
}


@Composable
fun ChatBody(navController: NavController, contactName: String?){
    Box{
        Image(painter = painterResource(R.drawable.fondochat),
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
                .padding(top = 30.dp, bottom = 16.dp)
        )
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, bottom = 16.dp)
            .imePadding()
        ){
            HeaderChat(navController, contactName)
            ChatSection(modifier = Modifier.weight(1f))

            EntradaTexto2()
        }
    }

}

@Composable
fun ChatSection(modifier: Modifier){
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 4.dp, end = 4.dp, top = 16.dp)

    ) {
        item {
            Mensaje(texto = "Holaap", false)
        }

        items(chats.size) {
            Mensaje(texto = chats[it], true)
            Spacer(Modifier.size(10.dp))
        }
    }
}

@Composable
fun Mensaje(
    texto: String?,
    isFromMe: Boolean){

    val myText = RoundedCornerShape(8.dp, 0.dp, 8.dp,8.dp)
    val otherText = RoundedCornerShape(0.dp, 8.dp, 8.dp,8.dp)

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if(isFromMe) Alignment.End else Alignment.Start
    ) {
        if (texto != null){
            if (texto.isNotEmpty()){
                Box(modifier = Modifier
                    .background(
                        color = if (isFromMe) colorResource(R.color.mensajeDrch) else colorResource(
                            R.color.mensajeIzq
                        ),
                        shape = if (isFromMe) myText else otherText
                    )
                    .padding(16.dp)
                ){
                    Text(text = texto,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }

        }
        }
    }


@Composable
fun HeaderChat(navController: NavController, contactName: String?){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = colorResource(R.color.headerWa))
            .fillMaxWidth()
            .height(65.dp)

    ) {

        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Atrás",
            tint = colorResource(R.color.white),
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    navController.navigate(route = AppScreen.HomeScreen.route)
                    chats.removeRange(0, chats.size)
                }
        )

        Icon(imageVector = Icons.Default.AccountCircle,
            contentDescription = "Contact",
            tint = colorResource(R.color.white),
            modifier = Modifier.size(45.dp)
        )

        contactName?.let { Text(text = it, color = Color.White, fontSize = 20.sp) }

        Spacer(Modifier.weight(1f))

        Image(painter = painterResource(R.drawable.videocam),
            contentDescription = "Videollamada",
            modifier = Modifier.size(30.dp)
        )



        Icon( imageVector = Icons.Default.Call,
            contentDescription = "Llamar",
            tint = colorResource(R.color.white),
            modifier = Modifier.size(30.dp)
        )

        Icon( imageVector = Icons.Filled.MoreVert,
            contentDescription = "Ver más",
            tint = colorResource(R.color.white),
            modifier = Modifier.size(30.dp)
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntradaTexto2(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = colorResource(R.color.entradaDeTexto))){
        OutlinedTextField(
            value = mensaje.value,
            onValueChange = {mensaje.value = it},
            shape = RoundedCornerShape(25.dp),
            trailingIcon = {

            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.White,
                focusedBorderColor = Color.Gray,
                cursorColor = Color.White,

            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(color = colorResource(R.color.entradaDeTexto))
        )

        Icon(imageVector = Icons.Default.Send,
            contentDescription = "Enviar",
            tint = Color.White,
            modifier = Modifier.clickable {
                chats.add(mensaje.value)
                mensaje.value = ""
        })
    }

}