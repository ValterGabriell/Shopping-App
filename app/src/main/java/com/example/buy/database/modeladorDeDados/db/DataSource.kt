package com.example.buy.database.modeladorDeDados.db

interface DataSource {

     fun add(modeladorComprasDados: ModeladorComprasDados)
     fun getAll(): List<ModeladorComprasDados>
     fun getVaor(): Float?
     fun deleteAll(modeladorComprasDados: ModeladorComprasDados)
     fun deleteId(id: Long)
     fun getId(id: Long): ModeladorComprasDados?
     fun updateNome(nome: String,preco : String, id: Long)


}