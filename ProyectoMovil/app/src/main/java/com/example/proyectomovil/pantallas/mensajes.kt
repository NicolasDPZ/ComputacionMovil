package com.example.proyectomovil.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectomovil.componentes.BarraAbajo
import com.example.proyectomovil.componentes.TopBar

@Composable
fun Mensajes(modifier : Modifier = Modifier, controladorNavegacion: NavController){
    Scaffold(
        topBar = { TopBar() },
        bottomBar ={ BarraAbajo(controladorNavegacion) }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = "Mensajes")

        }
    }
}


@Composable
@Preview(showBackground = true)
fun prevmensajes(){
    Mensajes(controladorNavegacion = rememberNavController())
}