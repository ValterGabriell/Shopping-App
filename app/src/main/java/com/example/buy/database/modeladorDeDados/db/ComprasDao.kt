package com.example.buy.database.modeladorDeDados.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.OnConflictStrategy.ROLLBACK

@Dao
interface ComprasDao {
    @Insert(onConflict = ROLLBACK)
    suspend fun addNewBuy(comprasEntity: ComprasEntity)

    @Query("SELECT * FROM tabela_compras")
    suspend fun getAll(): List<ComprasEntity>

    @Query("SELECT SUM(preco_produto) FROM tabela_compras")
    suspend fun getValor(): Float?

    @Query("DELETE FROM tabela_compras")
    suspend fun deleteAll()

    @Query("DELETE FROM tabela_compras WHERE idCompra = :id")
    suspend fun deleteId(id: Long)

    @Query("SELECT * FROM tabela_compras WHERE idCompra = :id")
    suspend fun getId(id: Long): ComprasEntity?

    @Query("UPDATE tabela_compras SET nome_produto  = :nome, preco_produto = :preco WHERE idCompra = :id")
    suspend fun updateNome(nome: String, preco: String, id: Long)


}