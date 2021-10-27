package com.example.buy.viewmodel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.database.modeladorDeDados.db.RoomDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NovoProtudoViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)


    fun addNewProduto(modeladorComprasDados: ModeladorComprasDados) {
        coroutineScope.launch {
            RoomDataSource(getApplication()).add(modeladorComprasDados)
        }
    }


    fun deleteAll(modeladorComprasDados: ModeladorComprasDados) {
        coroutineScope.launch {
            RoomDataSource(getApplication()).deleteAll(modeladorComprasDados)
        }
    }


}