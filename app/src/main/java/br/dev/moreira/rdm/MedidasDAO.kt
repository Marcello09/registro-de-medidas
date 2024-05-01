package br.dev.moreira.rdm

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MedidasDAO {
    @Query("SELECT * FROM medidas")
    fun getAll(): List<Medidas>

    @Insert
    fun insert(vararg medidas: Medidas)
}