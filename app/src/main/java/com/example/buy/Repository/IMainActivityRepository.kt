package com.example.buy.Repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados

interface IMainActivityRepository {
    fun getAllProdutos(
        application: Application,
        produtos: MutableLiveData<List<ModeladorComprasDados>>
    )

    fun getValor(
        application: Application,
        srtValorLV: MutableLiveData<String>
    )

    fun deleteAll(application: Application, modeladorComprasDados: ModeladorComprasDados)
}