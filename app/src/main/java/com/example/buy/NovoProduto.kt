package com.example.buy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.databinding.ActivityNovoProdutoBinding
import com.example.buy.viewmodel.NovoProtudoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class NovoProduto : AppCompatActivity() {

    private val viewModelNew by inject<NovoProtudoViewModel>()
    private lateinit var binding: ActivityNovoProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_novo_produto)
        supportActionBar?.title = "Nova compra"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        click()


    }

    private fun click() {

        binding.btnAdicionar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                if (binding.etNomeProduto.text.isNotEmpty()) {
                    if (binding.etPrecoProduto.text.isNotEmpty()) {
                        if (binding.etQtd.text.isNotEmpty()) {
                            val strNomeProduto: String = binding.etNomeProduto.text.toString()
                            val strPrecoProduto: String = binding.etPrecoProduto.text.toString()
                            val qtd: String = binding.etQtd.text.toString()
                            val valor: Float = strPrecoProduto.toFloat()
                            val qtdTotal = qtd.toFloat() * valor
                            val produtoASerSalvo =
                                ModeladorComprasDados(0, strNomeProduto, qtdTotal, qtd)
                            viewModelNew.addNewProduto(produtoASerSalvo)
                            finish()
                        }
                    }
                }
            }


        }
    }

}