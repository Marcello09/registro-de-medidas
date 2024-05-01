package br.dev.moreira.rdm

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Medidas::class], version = 1)
abstract class Database: RoomDatabase()  {
    abstract fun medidasDao(): MedidasDAO
}