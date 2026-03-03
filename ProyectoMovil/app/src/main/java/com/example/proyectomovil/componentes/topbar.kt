package com.example.proyectomovil.componentes

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.proyectomovil.R
import com.example.proyectomovil.ui.theme.barraArriba

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
