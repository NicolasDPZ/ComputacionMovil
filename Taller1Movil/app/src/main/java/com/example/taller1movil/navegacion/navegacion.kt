package com.example.taller1movil.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taller1movil.pantallas.Drivers
import com.example.taller1movil.pantallas.Juego
import com.example.taller1movil.pantallas.PantallaInicial


@Composable
fun Navegacion() {

    var navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Pantallas.pantallaInicial.name
    ) {

        composable(route = Pantallas.pantallaInicial.name) {
            PantallaInicial(navController = navController)
        }

        composable(route = Pantallas.conductores.name){
            Drivers(navController =navController)
        }

        composable(route = Pantallas.juego.name){
            Juego(navController=navController)
        }

    }
}