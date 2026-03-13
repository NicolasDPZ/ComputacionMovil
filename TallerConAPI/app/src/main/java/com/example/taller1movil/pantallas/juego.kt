package com.example.taller1movil.pantallas

import android.R
import androidx.annotation.Nullable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var numeroAleatorio by remember { mutableStateOf(value = (0..100).random()) }
    var numeroIngresado by remember { mutableStateOf(value = "") }
    var intentos by remember { mutableStateOf(value = 0) }
    var gano by remember { mutableStateOf(value = false) }
    var mensaje by remember { mutableStateOf(value = "") }

    Scaffold(
        topBar = { Topbar(navController) },
        floatingActionButton = { Reinicio {
            numeroAleatorio = (0..100).random()
            numeroIngresado = ""
            intentos = 0
            gano = false
            mensaje = ""
        }
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
                text = " Ingresa un numero del 0 al 100 ",
                fontSize = 30.sp,
                color= Color.Magenta,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(70.dp))

            TextField(
                placeholder = { Text("Ingresa tu numero...") },
                value = numeroIngresado,
                onValueChange = { numeroIngresado = it },
                enabled = !gano,
                modifier = Modifier.fillMaxWidth(). padding(12.dp)
            )

            Button(
                onClick = {
                    val numero = numeroIngresado.toInt()
                    intentos++
                    numeroIngresado=""

                    when {
                        numero < numeroAleatorio -> mensaje = "es mayor"
                        numero > numeroAleatorio -> mensaje = "es menor"
                        else -> {
                            gano = true
                            mensaje = "es correctoooo"
                        }
                    }
                },
                enabled = !gano && numeroIngresado.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth().padding(12.dp)
            ){
                Text(text = "Gess!!")
            }


            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "El numero: $numeroIngresado $mensaje",
                fontSize = 20.sp,
                color = if (gano) Color.Green else Color.Black,
                modifier = Modifier.padding(start = 20.dp)
            )

            Text(text = "Intentos: $intentos",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    }
}

@Composable
fun Reinicio(onReiniciar: () -> Unit){
    FloatingActionButton(
        onClick = { onReiniciar() }
    ){
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "reiniciar"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Topbar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(route = "pantallaInicial")
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Devolverse al menú"
                )
            }
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

@Preview
@Composable
fun PreviewJuego() {
    Juego(navController= rememberNavController())
}