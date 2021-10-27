package com.example.buy.view.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.util.isNotEmpty
import androidx.recyclerview.widget.RecyclerView
import com.example.buy.R
import com.example.buy.database.modeladorDeDados.db.ModeladorComprasDados

class ComprasAdapter(val listaCompras: MutableList<ModeladorComprasDados>) :
    RecyclerView.Adapter<ComprasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaCompras[position])

        holder.itemView.setOnClickListener {
            itemClick?.invoke(listaCompras[position].id)
        }

    }

    override fun getItemCount(): Int = listaCompras.size


    var itemClick: ((Long) -> Unit)? = null


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(modeladorComprasDados: ModeladorComprasDados) {
            with(modeladorComprasDados) {
                itemView.findViewById<TextView>(R.id.tvNoameProduto).text = this.name
                itemView.findViewById<TextView>(R.id.tvPreco).text = "R$: " + this.preco.toString()
                itemView.findViewById<TextView>(R.id.txtQtd).text = this.qtd
                if (modeladorComprasDados.selectd) {
                    itemView.findViewById<LinearLayout>(R.id.ln).background =
                        itemView.corBack(Color.rgb(26, 115, 233))
                    itemView.background = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = 32f
                        setColor(Color.BLUE)
                    }
                } else {
                    itemView.background = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = 32f
                        setColor(Color.WHITE)
                    }
                }
            }
        }


    }
}

private fun View.corBack(@ColorInt color: Int): ShapeDrawable {
    val forma = ShapeDrawable(RectShape())
    with(forma) {
        intrinsicWidth = width
        intrinsicHeight = height
        paint.color = color
    }
    return forma
}