package com.example.buy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados
import com.example.buy.databinding.ActivityEditarDeleteBinding
import com.example.buy.viewmodel.EditarDeleteViewModel

class EditarDelete : AppCompatActivity() {
    private lateinit var binding: ActivityEditarDeleteBinding
    private val viewModel: EditarDeleteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_editar_delete)
        supportActionBar?.title = "Editar compra"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.extras?.getLong("id")
        if (id != 0L) {
            viewModel.getId(id!!)
            viewModel.compraAtual.observe(this, {
                binding.etNome.setText(it.name)
                binding.etValor.setText(it.preco.toString())
                btnDeletar(id)
                btnEditar(id)
            })
        }
    }


    private fun btnDeletar(id: Long) {
        binding.btnDeletar.apply {
            text = "Deletar"
            setOnClickListener {
                viewModel.deleteId(id)
                finish()
            }
        }
    }

    private fun btnEditar(id: Long) {
        binding.btnEditar.apply {
            text = "Atualizar Produto"
            setOnClickListener {

                if (!binding.etNome.text.isEmpty()) {
                    if (!binding.etValor.text.isEmpty()) {
                        var srtNome: String = binding.etNome.text.toString()
                        var srtPreco: String = binding.etValor.text.toString()
                        viewModel.update(srtNome, srtPreco, id)
                        finish()
                    }
                }

            }
        }
    }
}