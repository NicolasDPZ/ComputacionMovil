package com.example.taller1movil.pantallas

import android.R
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

@Composable
fun Drivers(modifier: Modifier = Modifier, navController: NavController) {
    val context = LocalContext.current
    var conductores by remember { mutableStateOf(listOf<Conductor>()) }

    LaunchedEffect(Unit) {
        loadDriversFromAPI(context) { lista ->
            conductores = lista
        }
    }

    Scaffold(
        topBar = { TopbarDrivers(navController) }
    ) { padding ->
        LazyColumn(
            modifier = modifier
                .padding(paddingValues = padding)
                .fillMaxSize()
                .background(color = colorResource(id = R.color.darker_gray))
        ) {
            items(conductores) { item ->
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp)
                        .clickable {
                            navController.navigate(route = item)
                        }
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        AsyncImage(
                            model = item.foto,
                            contentDescription = "foto del condu",
                            modifier = Modifier.size(60.dp)
                        )

                        Text(
                            text = item.numero.toString(),
                            fontSize = 20.sp
                        )

                        Text(
                            text = item.nombre,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

fun loadDriversFromAPI(context: Context, onResult: (List<Conductor>) -> Unit) {
    val queue = Volley.newRequestQueue(context)
    val url = "https://api.openf1.org/v1/drivers?session_key=9930"

    val req = StringRequest(url,
        { response ->
            val lista = mutableListOf<Conductor>()
            val jsonArray = JSONArray(response)
            val vistos = mutableSetOf<Int>()
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val numero = obj.optInt("driver_number", 0)
                if (numero in vistos) continue
                vistos.add(numero)

                val nombre = obj.optString("full_name", "Desconocido")
                val foto = obj.optString("headshot_url", "")
                val acronimo = obj.optString( "name_acronym")
                val equipo = obj.optString("team_name")
                val colorEquipo = obj.optString("team_colour", "FFFFFF")
                lista.add(Conductor(numero, nombre, foto, acronimo, colorEquipo, equipo ))
            }
            onResult(lista.sortedBy { it.numero })
        },
        { error ->
            onResult(emptyList())
        }
    )
    queue.add(req)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopbarDrivers(navController : NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigate (route = "pantallainicial")
                }
            )
            {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Devolverse al menú"
                )
            }
        },
        title = {
            Text(
                text = "F1 drivers 2025"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.holo_red_dark)
        )
    )
}


@Preview
@Composable
fun PreviewConductores() {
    Drivers(navController = rememberNavController())
}