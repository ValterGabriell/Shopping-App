package com.example.buy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.buy.Repository.EditarActivityRepository
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.database.modeladorDeDados.db.RoomDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditarDeleteViewModel(
    private val editarActivityRepository: EditarActivityRepository,
    application: Application
) : AndroidViewModel(application) {

    val compraAtual = MutableLiveData<ModeladorComprasDados>()

    suspend fun getId(id: Long) {
        editarActivityRepository.getId(getApplication(), id, compraAtual)
    }

    suspend fun deleteId(id: Long) {
        editarActivityRepository.deleteId(getApplication(), id)
    }

    suspend fun update(nome: String, preco: String, id: Long) {
        editarActivityRepository.update(getApplication(), nome, preco, id)
    }

}