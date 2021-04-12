package com.example.androidjetpackexample.repositories

import com.example.androidjetpackexample.data.Libro
import com.example.androidjetpackexample.providers.LibrosProvider
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LibrosRepositoryImpl(
    private val librosProvider: LibrosProvider
) : LibrosRepository {

    override fun getLibros(): Single<List<Libro>> {
        return librosProvider
            .getLibros()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}