package com.example.buy.Repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.database.modeladorDeDados.db.RoomDataSource

class EditarActivityRepository : IEditarActivityRepository {
    override fun getId(
        application: Application,
        id: Long,
        compraAtual: MutableLiveData<ModeladorComprasDados>
    ) {
        val compra = RoomDataSource(application).getId(id)
        compraAtual.postValue(compra!!)
    }

    override fun deleteId(application: Application, id: Long) {
        RoomDataSource(application).deleteId(id)
    }

    override fun update(application: Application, nome: String, preco: String, id: Long) {
        RoomDataSource(application).updateNome(nome, preco, id)
    }
}