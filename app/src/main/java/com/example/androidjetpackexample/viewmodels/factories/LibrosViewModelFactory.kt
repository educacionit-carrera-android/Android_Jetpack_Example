package com.example.androidjetpackexample.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidjetpackexample.repositories.LibrosRepository
import com.example.androidjetpackexample.viewmodels.LibrosViewModel

class LibrosViewModelFactory(
    private val librosRepository: LibrosRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LibrosViewModel(librosRepository) as T
    }
}