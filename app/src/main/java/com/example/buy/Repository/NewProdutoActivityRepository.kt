package com.example.buy.Repository

import android.app.Application
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.database.modeladorDeDados.db.RoomDataSource

class NewProdutoActivityRepository : INewProdutoRepository {
    override fun addNewProduto(
        application: Application,
        modeladorComprasDados: ModeladorComprasDados
    ) {
        RoomDataSource(application).add(modeladorComprasDados)
    }
}