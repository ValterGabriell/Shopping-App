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

class NovoProduto : AppCompatActivity() {

    private val viewModelNew: NovoProtudoViewModel by viewModels()
    private lateinit var binding: ActivityNovoProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_novo_produto)
        supportActionBar?.title = "Nova compra"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        hideBtn()
        click()


    }

    private fun hideBtn() {
        val tamanhoLista = intent.extras?.getInt("tamanhoLista")
        if (tamanhoLista != 0) {
            binding.btnDelete.visibility = View.VISIBLE
        }

    }

    private fun click() {

        binding.btnAdicionar.setOnClickListener {

            if (!binding.etNomeProduto.text.isEmpty()) {
                if (!binding.etPrecoProduto.text.isEmpty()) {
                    if (!binding.etQtd.text.isEmpty()) {
                        val strNomeProduto: String = binding.etNomeProduto.text.toString()
                        val strPrecoProduto: String = binding.etPrecoProduto.text.toString()
                        val qtd: String = binding.etQtd.text.toString()
                        val valor: Float = strPrecoProduto.toFloat()
                        val qtdTotal = qtd.toFloat() * valor
                        val produtoASerSalvo = ModeladorComprasDados(0, strNomeProduto, qtdTotal, qtd)
                        viewModelNew.addNewProduto(produtoASerSalvo)
                        finish()
                    }
                    Toast.makeText(this, "Preencha tudo", Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(this, "Preencha tudo", Toast.LENGTH_SHORT).show()
            }


        }

        binding.btnDelete.setOnClickListener {
            val deleteAll = ModeladorComprasDados()
            viewModelNew.deleteAll(deleteAll)
            finish()
        }

    }

}