package com.example.taller1movil.pantallas

import android.R
import android.R.attr.top
import android.content.Context
import android.util.Log.e
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

@Composable
fun Pilotodetalles(
    conductor: Conductor,
    navController: NavController
) {
    Scaffold(
        topBar = { TopbarPilotoDetalles(navController) }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = conductor.colorEquipo()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(modifier = Modifier.padding(40.dp)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(20.dp)
                ) {
                    AsyncImage(
                        model = conductor.foto,
                        contentDescription = conductor.nombre,
                        modifier = Modifier.size(200.dp)
                    )
                    Text(
                        text = conductor.nombre,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                    Text(
                        text = "Número: ${conductor.numero}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "Acronimo: ${ conductor.acronimo}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "Equipo: ${conductor.equipo}",
                        fontSize = 18.sp,
                        color = conductor.colorEquipo(),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopbarPilotoDetalles(navController : NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {navController.navigate(route = "Drivers" )}
            ){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Devolverse al menú"
                )
            }
        },
        title = {
            Text(
                text = "Detalles"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.holo_red_dark)
        )
    )
}


@Preview
@Composable
fun previewPilotodetalles(){


}