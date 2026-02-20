package com.example.taller1entrega

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taller1entrega.ui.theme.Taller1EntregaTheme
import com.example.taller1entrega.ui.theme.pantallas

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
                    navController.navigate(pantallas.Paises.name)
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
            IconButton(onClick = {
                Log.i("TAG", "Call pressed")
            }) {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "Call"
                )
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            scrolledContainerColor = Color.Black
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
fun Paises(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.holo_purple))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )

    {

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "icono lindo",
                    Modifier.size(30.dp)
                )

                Text(
                    text = "hola buenas tardes",
                    Modifier.padding(20.dp)

                )
            }
        }

    }
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

        composable(route = pantallas.Paises.name) {
            Paises()
        }
    }

}


@Preview
@Composable
fun GreetinPreview() {
    Taller1EntregaTheme {
        Paises()
//        Home( navController = rememberNavController())
    }
}



