package com.example.buy.database.modeladorDeDados.db

import android.content.Context

class RoomDataSource(context: Context) : DataSource {
    val comprasDao = DatabaseService.getInstance(context).comprasDao()


    override fun add(modeladorComprasDados: ModeladorComprasDados) =
        comprasDao.addNewBuy(ComprasEntity.fromModel(modeladorComprasDados))

    override fun getAll(): List<ModeladorComprasDados> = comprasDao.getAll().map {
        it.getAll()
    }

    override fun getVaor(): Float? = comprasDao.getValor()

    override fun deleteAll(modeladorComprasDados: ModeladorComprasDados) =
        comprasDao.deleteAll()

    override fun deleteId(id: Long) = comprasDao.deleteId(id)

    override fun getId(id: Long): ModeladorComprasDados? = comprasDao.getId(id)?.getAll()
    override fun updateNome(nome: String, preco: String, id: Long) =
        comprasDao.updateNome(nome, preco, id)


}