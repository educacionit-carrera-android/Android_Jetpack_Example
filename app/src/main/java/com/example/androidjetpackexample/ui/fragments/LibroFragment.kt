package com.example.androidjetpackexample.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.androidjetpackexample.data.Libro
import com.example.androidjetpackexample.databinding.FragmentLibroBinding

class LibroFragment : Fragment() {

    private lateinit var binding: FragmentLibroBinding
    private var libro: Libro? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            libro = it.getParcelable(LIBRO)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLibroBinding.inflate(inflater, container, false)
        binding.libro = this.libro
        return binding.root
    }

    companion object {
        private const val LIBRO: String = "Libro"

        fun newInstance(libro: Libro) = LibroFragment()
            .apply {
                arguments = bundleOf(LIBRO to libro as Parcelable)
            }
    }
}