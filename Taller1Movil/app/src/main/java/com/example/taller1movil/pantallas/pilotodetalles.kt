package com.example.taller1movil.pantallas

import android.R
import android.content.Context
import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.json.JSONArray
import coil.compose.AsyncImage

var conductorSeleccionado: Conductor? = null
@Composable
fun Pilotodetalles(navController: NavController) {

    val conductor = conductorSeleccionado

    if (conductor == null) {
        Text("No hay piloto seleccionado")
        return
    }

    Scaffold(
        topBar = { TopbarPilotoDetalles(navController) }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier.padding(40.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    AsyncImage(
                        model = conductor.foto ?: "",
                        contentDescription = conductor.nombre,
                        modifier = Modifier.size(150.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = conductor.nombre)
                    Text(text = conductor.acronimo)
                    Text(
                        text = conductor.equipo,
                        color = conductor.colorEquipo.toColor()
                    )
                }
            }
        }
    }
}

fun String.toColor(): Color {
    return Color(parseColor("#$this"))
}

fun CargarConductoresdetalles(context: Context): MutableList<Conductor>{
    val conductores = mutableListOf<Conductor>()
    val jsonString =
        context.assets.open("drivers/f1drivers.json")
            .bufferedReader()
            .use { it.readText() }
    var jsonArray = JSONArray(jsonString)
    for (i in 0 until jsonArray.length()) {
        val jsonObject = jsonArray.getJSONObject(i)
        val numero = jsonObject.getInt("driver_number")
        val nombre = jsonObject.getString("full_name")
        val foto = jsonObject.getString("headshot_url")
        val acronimo = jsonObject.getString("name_acronym")
        val equipo = jsonObject.getString("team_name")
        val colorEquipo = jsonObject.getString( "team_colour")
        conductores.add(
            Conductor(
                numero,
                nombre,
                foto,
                acronimo,
                equipo,
                colorEquipo
            )
        )
    }
    return conductores
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

    Pilotodetalles(navController = rememberNavController())
}