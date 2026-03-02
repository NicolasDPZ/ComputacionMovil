package com.example.taller1movil.pantallas

import android.R
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material3.ElevatedCard
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import org.json.JSONArray

@Composable
fun Drivers(modifier: Modifier = Modifier, navController: NavController) {
    val context = LocalContext.current
    val conductores = remember {
        CargarConductores(context)
    }
    Scaffold(
        topBar = { TopbarDrivers() },
        ) { padding ->

        LazyColumn (
            modifier = modifier
                .padding(paddingValues = padding)
                .fillMaxSize()
                .background(color = colorResource(id = R.color.darker_gray))
        ) {
            items(items = conductores) { item ->
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            10.dp,
                            Alignment.Start
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.AssignmentInd,
                            contentDescription = "icono lindo",
                            modifier = Modifier.size(30.dp)
                        )
                        Text(
                            item.toString(),
                            fontSize = 25.sp
                        )
                    }
                }
            }

        }
    }
}

fun CargarConductores(context: Context): MutableList<Conductor>{
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
        conductores.add(Conductor(numero, nombre))
    }

    return conductores
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopbarDrivers() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Devolverse al menú"
            )
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