package com.example.androidjetpackexample.providers

import com.example.androidjetpackexample.data.Libro
import io.reactivex.Single

class LibrosProvider {

    fun getLibros(): Single<List<Libro>> {
        Thread.sleep(1500)
        return Single.just(
            listOf(
                Libro(
                    nombre = "Game of Thrones",
                    autor = "George R. R. Martin"
                ),
                Libro(
                    nombre = "Harry Potter",
                    autor = "J. K. Rowling"
                ),
                Libro(
                    nombre = "Maze Runner",
                    autor = "James Dashner"
                ),
            )
        )
    }

}