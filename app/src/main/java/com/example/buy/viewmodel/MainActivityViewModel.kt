package com.example.buy.viewmodel

import android.app.Application
import android.content.Context
import android.content.IntentFilter
import android.database.Cursor
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.database.modeladorDeDados.db.RoomDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.logging.LogManager

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val produtos = MutableLiveData<List<ModeladorComprasDados>>()
    val srtValorLV = MutableLiveData<String>()


    fun getAllProdutos() {
        coroutineScope.launch {
            val listaProdutos = RoomDataSource(getApplication()).getAll()
            produtos.postValue(listaProdutos)
        }
    }

    fun getValor() {
        coroutineScope.launch {
            val srtValor: String = RoomDataSource(getApplication()).getVaor()?.toString().toString()
            if (srtValor != null) {
                srtValorLV.postValue(srtValor)
            }

        }
    }

    fun deleteId(id: Long) {
        coroutineScope.launch {
            RoomDataSource(getApplication()).deleteId(id)

        }
    }


}