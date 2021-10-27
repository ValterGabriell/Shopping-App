package com.example.buy.database.modeladorDeDados.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_compras")
class ComprasEntity(
    @ColumnInfo(name =  "idCompra")
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "nome_produto")
    val nome: String,
    @ColumnInfo(name = "preco_produto")
    val preco: Float,
    @ColumnInfo(name = "quantidade")
    val qtd : String,
    @ColumnInfo(name = "selected")
    val selected:Boolean

    ) {

    companion object {
        fun fromModel(modeladorComprasDados: ModeladorComprasDados) = ComprasEntity(
            modeladorComprasDados.id,
            modeladorComprasDados.name, modeladorComprasDados.preco, modeladorComprasDados.qtd, modeladorComprasDados.selectd
        )

    }

    fun toBuy() = ModeladorComprasDados(id, nome, preco, qtd, selected)


}
