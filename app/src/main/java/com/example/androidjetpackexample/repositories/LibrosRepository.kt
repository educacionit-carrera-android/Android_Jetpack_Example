package com.example.androidjetpackexample.repositories

import com.example.androidjetpackexample.data.Libro
import io.reactivex.Single

interface LibrosRepository {
    fun getLibros(): Single<List<Libro>>
}