package com.example.taller1movil.pantallas

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable

    @Serializable
    data class Conductor(
        val numero: Int,
        val nombre: String,
        val foto: String,
        val acronimo: String,
        val colorEquipoHex: String,
        val equipo: String
    ) {
        fun colorEquipo(): Color {
            return try {
                Color(android.graphics.Color.parseColor("#$colorEquipoHex"))
            } catch (e: Exception) {
                Color.White
            }
        }
    }
