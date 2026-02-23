    package com.example.proyectomovil

import android.os.Bundle
import androidx.compose.foundation.layout.Row
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomovil.ui.theme.ProyectoMovilTheme
import com.example.proyectomovil.ui.theme.barraAbajo
import com.example.proyectomovil.ui.theme.barraArriba
import com.example.proyectomovil.ui.theme.fondo
import com.example.proyectomovil.ui.theme.pantallas

    class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoMovilTheme {
                Navegacion()
                }
            }
        }
    }


@Composable
fun login( modifier: Modifier = Modifier){

    Column() { }

}

@Composable
fun Home(modifier : Modifier = Modifier, controladorNavegacion: NavController){
    Scaffold(
        topBar = {TopBar()},
        bottomBar ={BarraAbajo(controladorNavegacion)}

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(fondo)
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Home")


        }
    }
}

@Composable
fun Crear(modifier : Modifier = Modifier, controladorNavegacion: NavController){
    Scaffold(
        topBar = {TopBar()},
        bottomBar ={BarraAbajo(controladorNavegacion)}

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
@Composable
    fun Mapa(modifier : Modifier = Modifier, controladorNavegacion: NavController){
        Scaffold(
            topBar = {TopBar()},
            bottomBar ={BarraAbajo(controladorNavegacion)}

        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Mapa")


            }
        }
    }

    @Composable
    fun Mensajes(modifier : Modifier = Modifier, controladorNavegacion: NavController){
        Scaffold(
            topBar = {TopBar()},
            bottomBar ={BarraAbajo(controladorNavegacion)}

        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center
            ) {

                Text(text = "Mensajes")

            }
        }
    }

    @Composable
    fun Perfil(modifier : Modifier = Modifier, controladorNavegacion: NavController){
        Scaffold(
            topBar = {TopBar()},
            bottomBar ={BarraAbajo(controladorNavegacion)}

        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "perfil")

            }
        }
    }




    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBar() {

        CenterAlignedTopAppBar(
            title = { Text(text = "JaveApp",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )},

            navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "imagen logo"
                )
            },

            actions = {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "opciones",
                )},

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = barraArriba,
                scrolledContainerColor = Color.White
            )
        )
    }

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


@Preview
@Composable
fun previews(){
    ProyectoMovilTheme{
        Home(controladorNavegacion = rememberNavController())
    }
}
