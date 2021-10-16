package com.example.buy.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buy.MainAction
import com.example.buy.R
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados

class ComprasAdapter(private val context: Context, private val listaCompras : List<ModeladorComprasDados>, val action: MainAction) :
    RecyclerView.Adapter<ComprasAdapter.ViewHolder>() {

    //private lateinit var mListener : onClickListener
/*
    interface onClickListener{
        fun onItemClick(position: Long)
    }

    fun setOnClickListener(listener : onClickListener){
        mListener = listener
    }

 */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modeladorComprasDados = listaCompras[position]
        holder.let {
            it.nomeProduto.text = modeladorComprasDados.name
            it.precoProduto.text = "R$: " + modeladorComprasDados.preco.toString()

            it.nomeProduto.setOnClickListener{
                action.enterId(modeladorComprasDados.id)
            }
            it.precoProduto.setOnClickListener{
                action.enterId(modeladorComprasDados.id)
            }
        }
    }

    override fun getItemCount(): Int = listaCompras.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nomeProduto: TextView = itemView.findViewById(R.id.tvNoameProduto)
            val precoProduto: TextView = itemView.findViewById(R.id.tvPreco)

        //para por o click na acitivty, passa o listener no construtor do view holder
        /*
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition.toLong())
            }
        }

         */


    }


}