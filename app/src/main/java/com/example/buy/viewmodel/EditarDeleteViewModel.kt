package com.example.buy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.database.modeladorDeDados.db.RoomDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditarDeleteViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val compraAtual = MutableLiveData<ModeladorComprasDados>()

    fun getId(id: Long) {
        coroutineScope.launch {
            val compra = RoomDataSource(getApplication()).getId(id)
            compraAtual.postValue(compra!!)
        }
    }

    fun deleteId(id: Long) {
        coroutineScope.launch {
            RoomDataSource(getApplication()).deleteId(id)
        }
    }

    fun update(nome: String,preco : String, id: Long){
        coroutineScope.launch {
            RoomDataSource(getApplication()).updateNome(nome, preco,id)
        }
    }

}