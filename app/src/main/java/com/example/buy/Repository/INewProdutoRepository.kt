package com.example.buy.Repository

import android.app.Application
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados

interface INewProdutoRepository {
    fun addNewProduto(application: Application, modeladorComprasDados: ModeladorComprasDados)
}