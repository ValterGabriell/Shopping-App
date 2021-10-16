package com.example.buy.database.modeladorDeDados.db

interface DataSource {

    suspend fun add(modeladorComprasDados: ModeladorComprasDados)
    suspend fun getAll(): List<ModeladorComprasDados>
    suspend fun getVaor(): Float?
    suspend fun deleteAll(modeladorComprasDados: ModeladorComprasDados)
    suspend fun deleteId(id: Long)
    suspend fun getId(id: Long): ModeladorComprasDados?
    suspend fun updateNome(nome: String,preco : String, id: Long)


}