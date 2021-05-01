package com.example.androidjetpackexample.mappers

import com.example.androidjetpackexample.data.Libro
import com.example.androidjetpackexample.db.data.LibroEntity

object LibrosMapper {
    fun LibroEntity.toLibro() = Libro(
        nombre = nombre,
        autor = autor
    )

    fun List<LibroEntity>.toLibros() = map {
        it.toLibro()
    }
}