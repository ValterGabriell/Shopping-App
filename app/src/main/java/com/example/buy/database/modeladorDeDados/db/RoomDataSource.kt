package com.example.buy.database.modeladorDeDados.db

import android.content.Context

class RoomDataSource(context: Context) : DataSource {
    val comprasDao = DatabaseService.getInstance(context).comprasDao()


    override suspend fun add(modeladorComprasDados: ModeladorComprasDados) =
        comprasDao.addNewBuy(ComprasEntity.fromModel(modeladorComprasDados))

    override suspend fun getAll(): List<ModeladorComprasDados> = comprasDao.getAll().map {
        it.toBuy()
    }

    override suspend fun getVaor(): Float? = comprasDao.getValor()

    override suspend fun deleteAll(modeladorComprasDados: ModeladorComprasDados) =
        comprasDao.deleteAll()

    override suspend fun deleteId(id: Long) = comprasDao.deleteId(id)

    override suspend fun getId(id: Long) : ModeladorComprasDados? = comprasDao.getId(id)?.toBuy()
    override suspend fun updateNome(nome: String,preco : String, id: Long) = comprasDao.updateNome(nome,preco, id)


}