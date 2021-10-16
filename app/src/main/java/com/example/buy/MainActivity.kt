package com.example.buy

import android.annotation.SuppressLint
import android.app.ActionBar
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buy.database.modeladorDeDados.db.ComprasDao
import com.example.buy.databinding.ActivityMainBinding
import com.example.buy.view.adapter.ComprasAdapter
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.viewmodel.MainActivityViewModel
import com.example.buy.viewmodel.NovoProtudoViewModel
import java.util.*
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity(), MainAction {


    /**
     * TUDO QUE TA COMENTANDO E REFERENTE AO CLICK DO RV
     */

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private var produtosList = ArrayList<ModeladorComprasDados>()



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
            if (produtosList.size > 0){
                binding.tvValor.text = "Valor: R$ $it"
            }

        })
    }


    private fun configurarRv() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvCompras.layoutManager = layoutManager
        produtosList.reverse()
        var adapter = ComprasAdapter(this, produtosList, this)
        binding.rvCompras.adapter = adapter

        //click
/*
        adapter.setOnClickListener(object : ComprasAdapter.onClickListener{
            override fun onItemClick(position: Long) {
              enterId(position)
            }
        })

 */
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllProdutos()
        viewModel.getValor(produtosList)
    }

    private fun tvTratamento(){
        if (produtosList.size != 0) {
            binding.tvValor.visibility = View.VISIBLE
        }else{
            binding.tvValor.text = "Insira um produto"
        }
    }

    override fun enterId(id: Long) {
        val intent = Intent(this, EditarDelete::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }



}