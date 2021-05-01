package com.example.androidjetpackexample.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidjetpackexample.data.Libro
import com.example.androidjetpackexample.databinding.FragmentLibrosBinding
import com.example.androidjetpackexample.db.LibrosDatabase
import com.example.androidjetpackexample.repositories.LibrosRepositoryImpl
import com.example.androidjetpackexample.ui.adapters.LibrosAdapter
import com.example.androidjetpackexample.viewmodels.LibrosViewModel
import com.example.androidjetpackexample.viewmodels.factories.LibrosViewModelFactory

class LibrosFragment : Fragment() {

    private var libroClickListener: LibroClickListener? = null
    private val viewModel: LibrosViewModel by viewModels {
        LibrosViewModelFactory(
            LibrosRepositoryImpl(
                LibrosDatabase
                    .getInstance(requireContext())
                    .librosDao()
            )
        )
    }

    private val adapter = LibrosAdapter { libroClickListener?.onLibroClicked(it) }
    private val TAG: String = LibrosFragment::class.java.simpleName
    private var _binding: FragmentLibrosBinding? = null
    private val binding get() = _binding!! // Propiedad válida entre onCreateView y onDestroyView.

    override fun onAttach(context: Context) {
        super.onAttach(context)
        libroClickListener = context as LibroClickListener?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(TAG, "onCreateView")
        _binding = FragmentLibrosBinding.inflate(inflater, container, false)

        configurarAdapter()
        /* viewModel = ViewModelProvider(   // Solución a utilizar si se está en un archivo Java.
            this,
            LibrosViewModelFactory(
                LibrosRepositoryImpl(LibrosProvider())
            )
        ).get(LibrosViewModel::class.java) */
        bindViewModel()

        return binding.root
    }

    private fun bindViewModel() {
        viewModel.libros.observe(viewLifecycleOwner, { actualizarLibros(it) })
        viewModel.mensaje.observe(viewLifecycleOwner, ::mostrarMensaje)
    }

    private fun actualizarLibros(libros: List<Libro>) {
        adapter.actualizarLibros(libros)
    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_LONG).show()
    }

    private fun configurarAdapter() {
        binding.recyclerViewLibros.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    interface LibroClickListener {
        fun onLibroClicked(libro: Libro)
    }
}