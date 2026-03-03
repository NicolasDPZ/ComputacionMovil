package com.example.proyectomovil.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.proyectomovil.componentes.BarraAbajo
import com.example.proyectomovil.componentes.TopBar

@Composable
fun Crear(modifier : Modifier = Modifier, controladorNavegacion: NavController){
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
            Text(text = "Crear")


        }
    }
}
