package com.example.androidjetpackexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidjetpackexample.db.dao.LibrosDao
import com.example.androidjetpackexample.db.data.LibroEntity

const val DB_VERSION = 1
const val DB_NAME = "libros_database"

@Database(entities = [LibroEntity::class], version = DB_VERSION, exportSchema = false)
abstract class LibrosDatabase : RoomDatabase() {

    abstract fun librosDao(): LibrosDao

    companion object {
        @Volatile
        private var instance: LibrosDatabase? = null

        fun getInstance(context: Context): LibrosDatabase {
            return instance ?: synchronized(this) {
                instance ?: createDatabase(context).also { instance = it }
            }
        }

        private fun createDatabase(context: Context): LibrosDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                LibrosDatabase::class.java,
                DB_NAME
            ).build()
        }
    }
}