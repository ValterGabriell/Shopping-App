package com.example.buy.viewmodel

import android.app.Application
import android.content.Context
import android.content.IntentFilter
import android.database.Cursor
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.buy.Repository.MainActivityRepository
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.database.modeladorDeDados.db.RoomDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.logging.LogManager

class MainActivityViewModel(
    private val mainActivityRepository: MainActivityRepository,
    application: Application
) : AndroidViewModel(application) {

    val produtos = MutableLiveData<List<ModeladorComprasDados>>()
    val srtValorLV = MutableLiveData<String>()


    suspend fun getAllProdutos() {
        mainActivityRepository.getAllProdutos(getApplication(), produtos)
    }

    suspend fun getValor() {
        mainActivityRepository.getValor(getApplication(), srtValorLV)
    }

    suspend fun deleteAll(modeladorComprasDados: ModeladorComprasDados) {
        mainActivityRepository.deleteAll(getApplication(), modeladorComprasDados)
    }
}