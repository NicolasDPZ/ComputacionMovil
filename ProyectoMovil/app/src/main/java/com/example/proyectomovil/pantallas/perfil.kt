package com.example.proyectomovil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.proyectomovil.componentes.BarraAbajo
import com.example.proyectomovil.componentes.TopBar
import com.example.proyectomovil.ui.theme.barraArriba
import com.example.proyectomovil.ui.theme.fondo

@Composable
fun Perfil(modifier: Modifier = Modifier, controladorNavegacion: NavController) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BarraAbajo(controladorNavegacion) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(fondo)
                .padding(paddingValues)
        ) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth().background(barraArriba).padding(16.dp)
                ) {
                    Text(
                        text = "YOKS (yoks@universidadXYZ.edu.co)", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White
                    )
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = barraArriba)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Foto de perfil
                            Box(
                                modifier = Modifier.size(60.dp).clip(CircleShape).background(Color.Gray).clickable { },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Foto", fontSize = 12.sp, color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "YOKS", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black
                                )
                                Text(
                                    text = "Universidad XYZ", fontSize = 14.sp, color = Color.Black
                                )
                                Text(
                                    text = "Carrera XYZ", fontSize = 14.sp, color = Color.Black
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                // Git
                                Box(
                                    modifier = Modifier.size(40.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.git),
                                        contentDescription = "Git",
                                        modifier = Modifier.size(40.dp)
                                    )
                                }

                                // In
                                Box(
                                    modifier = Modifier.size(40.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.inimagen),
                                        contentDescription = "In",
                                        modifier = Modifier.size(40.dp)
                                    )
                                }

                                // Disco
                                Box(
                                    modifier = Modifier.size(40.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.disco),
                                        contentDescription = "Disco",
                                        modifier = Modifier.size(40.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Grupos de estudio", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {},
                                modifier = Modifier.height(40.dp).width(55.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF1976D2)
                                )
                            ) {
                                Text(
                                    text = "+", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Proyectos actuales
                        Text(
                            text = "Proyectos actuales", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {},
                                modifier = Modifier.height(40.dp).width(55.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF1976D2)
                                )
                            ) {
                                Text(
                                    text = "+", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black
                                )
                            }
                        }

                    }
                }
            }

            // Publicaciones
            item {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "Publicaciones", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = barraArriba)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(12.dp)
                        ) {
                            Text(
                                text = "todavia no publico nada", fontSize = 14.sp, color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun prevperfil(){
    Perfil(controladorNavegacion = rememberNavController())
}