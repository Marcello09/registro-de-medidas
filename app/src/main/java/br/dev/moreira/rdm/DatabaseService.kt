package br.dev.moreira.rdm

import android.content.Context
import androidx.room.Room


class DatabaseService()  {
    companion object {
        private var dbInstance: Database? = null

        fun getDB(): Database {
            return dbInstance as Database
        }

        fun init(context: Context) {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder(
                    context,
                    Database::class.java, "medidas"
                ).build()
            }
        }
    }
}