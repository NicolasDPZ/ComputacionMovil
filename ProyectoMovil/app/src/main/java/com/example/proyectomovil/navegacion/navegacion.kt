package com.example.proyectomovil.navegacion

import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomovil.Perfil
import com.example.proyectomovil.pantallas.Crear
import com.example.proyectomovil.pantallas.Home
import com.example.proyectomovil.pantallas.Mapa
import com.example.proyectomovil.pantallas.Mensajes
import com.example.proyectomovil.pantallas.pantallas


@Composable
fun Navegacion(){
    val controladorNavegacion = rememberNavController()
    NavHost(
        navController = controladorNavegacion,
        startDestination = pantallas.Home.name
    )
    {
        composable(route = pantallas.Home.name){
            Home(controladorNavegacion = controladorNavegacion)
        }
        composable(route = pantallas.Crear.name){
            Crear(controladorNavegacion = controladorNavegacion)
        }
        composable (route = pantallas.Mapa.name){
            Mapa(controladorNavegacion = controladorNavegacion)
        }
        composable ( route = pantallas.Mensajes.name ){
            Mensajes(controladorNavegacion = controladorNavegacion)
        }
        composable ( route = pantallas.Perfil.name ){
            Perfil(controladorNavegacion = controladorNavegacion)
        }
    }
}

