package com.example.androidjetpackexample.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Libros")
class LibroEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nombre_libro") val nombre: String,
    @ColumnInfo(name = "nombre_autor") val autor: String
)