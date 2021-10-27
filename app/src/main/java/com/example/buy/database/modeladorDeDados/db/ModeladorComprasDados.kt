package com.example.buy.database.modeladorDeDados.db

data class ModeladorComprasDados(
    val id: Long= 0L,
    val name: String = "",
    val preco: Float = 0F,
    val qtd: String = "",
    var selectd : Boolean = false
)