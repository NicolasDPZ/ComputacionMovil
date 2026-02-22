package com.example.taller1entrega.ui.theme

data class Country(
    val name: String,
    val capital: String
){
    override fun toString(): String = "$name - $capital"
}
