package com.example.androidjetpackexample.repositories

import com.example.androidjetpackexample.data.Libro
import com.example.androidjetpackexample.db.dao.LibrosDao
import com.example.androidjetpackexample.mappers.LibrosMapper.toLibros
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LibrosRepositoryImpl(
    private val dao: LibrosDao
) : LibrosRepository {

    override fun getLibros(): Single<List<Libro>> {
        return dao
            .getLibros()
            .map { it.toLibros() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}