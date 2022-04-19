package com.example.buy.Repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados

interface IEditarActivityRepository {
    fun getId(
        application: Application,
        id: Long,
        compraAtual: MutableLiveData<ModeladorComprasDados>
    )

    fun deleteId(application: Application, id: Long)

    fun update(application: Application, nome: String, preco: String, id: Long)
}