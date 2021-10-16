package com.example.buy.database.modeladorDeDados.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ComprasEntity::class], version = 5, exportSchema = false)

abstract class DatabaseService : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "databaseCompras"
        private var INSTANCE: DatabaseService? = null

        private fun create (context: Context) : DatabaseService =
            Room.databaseBuilder(
                context, DatabaseService::class.java, DATABASE_NAME
            ).fallbackToDestructiveMigration().build()
        fun getInstance(context: Context) : DatabaseService = (INSTANCE ?: create(context)).also { INSTANCE = it }

    }

    abstract fun comprasDao() : ComprasDao}



