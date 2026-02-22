package com.example.taller1entrega

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.lazy.items
import com.example.taller1entrega.ui.theme.Country
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taller1entrega.ui.theme.Taller1EntregaTheme
import com.example.taller1entrega.ui.theme.pantallas
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller1EntregaTheme {
                Navegacion()
            }
        }
    }
}


@Composable
fun Home(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    Scaffold(
        topBar = { MyTopBar() },
        floatingActionButton = { MyFloatingActionButton() }
    ) { p: PaddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues = p)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
                space = 10.dp,
                Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {
                    navController.navigate(pantallas.PantallaPaises.name)
                },

                modifier = Modifier.padding(all = 20.dp)
            ) {
                Text(text = "Lista de Paises")
            }

            Text(text = "Al presionar el boton salen los paises!!!")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {

    TopAppBar(
        title = { Text(text = "Home bar") },

        navigationIcon = {
            IconButton(onClick = {
                Log.i("TAG", "Navigation icon pressed")
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back button"
                )
            }
        },

        actions = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "tres barritas",
            )},


        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.white),
            scrolledContainerColor = Color.White
        )
    )
}

@Composable
fun MyFloatingActionButton() {

    val context = LocalContext.current

    FloatingActionButton(
        onClick = {
            Toast.makeText(
                context,
                "hola mundo",
                Toast.LENGTH_LONG
            ).show()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add"
        )
    }
}


@Composable
fun PantallaPaises(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val countries = remember {
        loadCountries(context)
    }
    Scaffold(
        topBar = { MyTopBar() }
    ) { paddingValues ->

        LazyColumn (
            modifier = Modifier
                .padding(paddingValues),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(items = countries){item ->
                ElevatedCard (modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Row (
                        horizontalArrangement = Arrangement.
                        spacedBy(10.dp,
                            Alignment.Start),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "icono lindo",
                            modifier = Modifier.size(30.dp)
                        )
                        Text(item.toString(),
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}
fun loadCountries(context: Context): MutableList<Country> {

    val countries = mutableListOf<Country>()

    val json_string = context.assets
        .open("paises.json")
        .bufferedReader()
        .use { it.readText() }

    val json = JSONObject(json_string)
    val paisesJsonArray = json.getJSONArray("paises")

    for (i in 0..paisesJsonArray.length()-1) {

        val jsonObject = paisesJsonArray.getJSONObject(i)

        val capital = jsonObject.getString("capital")
        val name = jsonObject.getString("nombre_pais")

        val country = Country(name, capital)
        countries.add(country)
    }

    return countries
}


@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = pantallas.Home.name
    )
    {

        composable(route = pantallas.Home.name) {
            Home(navController = navController)
        }

        composable(route = pantallas.PantallaPaises.name) {
            PantallaPaises()
        }
    }

}


@Preview
@Composable
fun GreetinPreview() {
    Taller1EntregaTheme {
        PantallaPaises()
//       Home( navController = rememberNavController())
    }
}



