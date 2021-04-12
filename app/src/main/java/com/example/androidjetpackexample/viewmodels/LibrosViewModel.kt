package com.example.androidjetpackexample.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidjetpackexample.data.Libro
import com.example.androidjetpackexample.repositories.LibrosRepository
import io.reactivex.disposables.CompositeDisposable

class LibrosViewModel(
    private val librosRepository: LibrosRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val TAG = LibrosViewModel::class.simpleName
    private val _libros = MutableLiveData<List<Libro>>()
    val libros: LiveData<List<Libro>> = _libros

    private val _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> = _mensaje

    init {
        retrieveLibros()
        Log.i(TAG, "init")
    }

    private fun retrieveLibros() {
        compositeDisposable.add(
            librosRepository
                .getLibros()
                .subscribe({ libros ->
                    _libros.value = libros
                }, {
                    _mensaje.value = "No se pudieron obtener los libros"
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}