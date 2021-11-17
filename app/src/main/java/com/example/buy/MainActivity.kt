package com.example.buy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.databinding.ActivityMainBinding
import com.example.buy.view.adapter.ComprasAdapter
import com.example.buy.viewmodel.MainActivityViewModel
import java.util.*

class MainActivity : AppCompatActivity() {


    /**
     * TUDO QUE TA COMENTANDO E REFERENTE AO CLICK DO RV
     */

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private var produtosList = ArrayList<ModeladorComprasDados>()
    private lateinit var adapter: ComprasAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.title = "Lista de Compras"


        adicionarOberserver()
        btnClicks()
        configurarRv()

    }


    private fun btnClicks() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, NovoProduto::class.java)
            intent.putExtra("tamanhoLista", produtosList.size)
            startActivity(intent)
        }

    }


    private fun adicionarOberserver() {
        viewModel.produtos.observe(this, {
            produtosList = it as ArrayList<ModeladorComprasDados>
            configurarRv()
            tvTratamento()
        })

        viewModel.srtValorLV.observe(this, {
            if (produtosList.size > 0) {
                binding.tvValor.text = "Valor: R$ $it"
            }

        })
    }


    private fun configurarRv() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvCompras.layoutManager = layoutManager
        produtosList.reverse()
        adapter = ComprasAdapter(produtosList)
        binding.rvCompras.adapter = adapter

        adapter.itemClick = {
            val intent = Intent(this, EditarDelete::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllProdutos()
        viewModel.getValor()
    }

    private fun tvTratamento() {
        if (produtosList.size != 0) {
            binding.tvValor.visibility = View.VISIBLE
        } else {
            binding.tvValor.text = "Insira um produto"
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete_All){
            val modeladorComprasDados = ModeladorComprasDados()
            viewModel.deleteAll(modeladorComprasDados)
            onResume()
        }
        return super.onOptionsItemSelected(item)
    }
}
