package com.example.buy.viewmodel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.buy.Repository.NewProdutoActivityRepository

import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.database.modeladorDeDados.db.RoomDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NovoProtudoViewModel(
    private val newProdutoActivityRepository: NewProdutoActivityRepository,
    application: Application
) : AndroidViewModel(application) {


    suspend fun addNewProduto(modeladorComprasDados: ModeladorComprasDados) {

        newProdutoActivityRepository.addNewProduto(getApplication(), modeladorComprasDados)

    }


}