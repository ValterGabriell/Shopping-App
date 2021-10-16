package com.example.buy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.databinding.ActivityNovoProdutoBinding
import com.example.buy.viewmodel.NovoProtudoViewModel

class NovoProduto : AppCompatActivity() {

    private val viewModelNew : NovoProtudoViewModel by viewModels()
    private lateinit var binding : ActivityNovoProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_novo_produto)
        supportActionBar?.title = "Nova compra"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

       hideBtn()
        click()







    }

    private fun hideBtn(){
        val tamanhoLista = intent.extras?.getInt("tamanhoLista")
        if (tamanhoLista != 0){
            binding.btnDelete.visibility = View.VISIBLE
        }

    }
    private fun click() {

            binding.btnAdicionar.setOnClickListener {
                var strNomeProduto: String = binding.etNomeProduto.text.toString()
                var strPrecoProduto: String = binding.etPrecoProduto.text.toString()
                var qtd : String = binding.etQtd.text.toString()
                var valor: Float = strPrecoProduto.toFloat()
                var qtdTotal = qtd.toFloat() * valor
                var produtoASerSalvo = ModeladorComprasDados(0, strNomeProduto, qtdTotal)
                viewModelNew.addNewProduto(produtoASerSalvo)
                finish()

        }

        binding.btnDelete.setOnClickListener {
            var deleteAll = ModeladorComprasDados()
            viewModelNew.deleteAll(deleteAll)
            finish()
        }

    }

}