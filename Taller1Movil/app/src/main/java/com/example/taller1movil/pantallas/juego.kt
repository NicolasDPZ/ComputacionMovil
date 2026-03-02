package com.example.taller1movil.pantallas

import android.R
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Juego(modifier: Modifier = Modifier, navController: NavController){

//    var numeroAleatorio by remember { mutableStateOf((1..100).random()) }
//    var numeroIngresado by remember { mutableStateOf("") }
//    var mensaje by remember { mutableStateOf("") }
//    var intentos by remember { mutableStateOf(0) }
//    var juegoTerminado by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { Topbar() },
        floatingActionButton = { Reinicio(navController)
        }
    ) { padding ->

        Column(

            modifier = modifier
                .padding(paddingValues = padding)
                .fillMaxSize()
                .background(color = colorResource(id = R.color.darker_gray))
        )
        {
            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = " Ingresa un numero del 1 al 100 ",
                fontSize = 30.sp,
                color=colorResource( id= R.color.holo_purple),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(70.dp))


//            OutlinedTextField(
//                value = numeroIngresado,
//                onValueChange = { numeroIngresado = it },
//                enabled = !juegoTerminado,
//                label = { Text("Número") }
//            )
//
//            Text(
//                text = mensaje,
//                color = if (juegoTerminado) Color.Green else Color.Black,
//                fontSize = 18.sp
//            )
//
//            Spacer(modifier = Modifier.height(10.dp))
//            Text("Intentos: $intentos")

        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Topbar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Devolverse al menú"
            )
        },
        title = {
            Text(
                text = "Guess Game"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.holo_blue_light)
        )
    )
}

@Composable
fun Reinicio(navController: NavController){
    FloatingActionButton(
        onClick = {
            navController.navigate(route = "pantallaInicial")
        }){
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "reiniciar el juego"
        )
    }

}


@Preview
@Composable
fun PreviewJuego() {
    Juego(navController= rememberNavController())
}