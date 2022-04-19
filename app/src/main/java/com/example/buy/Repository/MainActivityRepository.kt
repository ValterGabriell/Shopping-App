package com.example.buy.Repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.database.modeladorDeDados.db.RoomDataSource

class MainActivityRepository() : IMainActivityRepository {
    override fun getAllProdutos(
        application: Application,
        produtos: MutableLiveData<List<ModeladorComprasDados>>
    ) {
        val listaProdutos = RoomDataSource(application).getAll()
        produtos.postValue(listaProdutos)
    }

    override fun getValor(
        application: Application,
        srtValorLV: MutableLiveData<String>
    ) {
        val srtValor: String = RoomDataSource(application).getVaor()?.toString().toString()
        srtValorLV.postValue(srtValor)
    }

    override fun deleteAll(application: Application, modeladorComprasDados: ModeladorComprasDados) {
        RoomDataSource(application).deleteAll(modeladorComprasDados)
    }
}