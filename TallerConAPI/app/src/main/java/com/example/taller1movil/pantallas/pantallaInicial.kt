package com.example.taller1movil.pantallas

import android.R.attr.onClick
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.taller1movil.R

@Composable
fun PantallaInicial(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = android.R.color.holo_orange_light))
    ) {


        ElevatedCard(
            onClick = {
                navController.navigate(route = "juego")
            },
            modifier = Modifier
                .padding(all = 32.dp)
                .size(size = 320.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.numbers),
                contentDescription = ("imagen numeros"),
                modifier = modifier
                    .clickable {
                        navController.navigate(route = "juego")
                    }
                    .padding(all = 12.dp)
                    .size(size = 300.dp)
            )
        }


        ElevatedCard(
            onClick = {
                navController.navigate(route = "Drivers")
            },
            modifier = Modifier
                .padding(all = 32.dp)
                .size(size = 320.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.driver),
                contentDescription = ("imagen conductor"),
                modifier = modifier
                    .clickable {
                        navController.navigate(route = "Drivers")
                    }
                    .padding(all = 12.dp)
                    .size(size = 300.dp)
            )
        }
    }
}


@Preview
@Composable
fun PreviewPantallaInicial() {
    PantallaInicial(navController = rememberNavController())
}