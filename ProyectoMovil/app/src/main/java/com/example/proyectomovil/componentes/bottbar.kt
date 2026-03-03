package com.example.proyectomovil.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.proyectomovil.pantallas.pantallas
import com.example.proyectomovil.ui.theme.barraAbajo


@Composable
fun BarraAbajo( controladorNavegacion : NavController){
    BottomAppBar(

        actions = {
            Row (
                modifier = Modifier
                    .background(barraAbajo)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,

                ) {

                IconButton(onClick = {controladorNavegacion.navigate(route = pantallas.Mapa.name)} ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "mapita"
                    )
                }

                IconButton(onClick = {controladorNavegacion.navigate(route = pantallas.Crear.name)}) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "crear"
                    )
                }

                IconButton(onClick = {controladorNavegacion.navigate(route = pantallas.Home.name)}) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "home"
                    )
                }

                IconButton(onClick = { controladorNavegacion.navigate(route = pantallas.Mensajes.name)}) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "mensajes"
                    )
                }

                IconButton(onClick = {controladorNavegacion.navigate(route= pantallas.Perfil.name)}) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "perfil"
                    )
                }
            }
        }
    )
}