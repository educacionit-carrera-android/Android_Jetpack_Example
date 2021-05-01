package com.example.androidjetpackexample.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjetpackexample.R
import com.example.androidjetpackexample.data.Libro

class LibrosAdapter(
    private val onLibroClicked: (libro: Libro) -> Unit
) : RecyclerView.Adapter<LibrosAdapter.LibrosViewHolder>() {

    private var libros = ArrayList<Libro>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibrosViewHolder {
        return LibrosViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_libro, parent, false)
        )
    }

    override fun getItemCount(): Int = libros.size

    override fun onBindViewHolder(holder: LibrosViewHolder, position: Int) {
        val libro: Libro = libros[position]
        holder.apply {
            textViewNombre.text = libro.nombre
            textViewAutor.text = libro.autor
            itemView.setOnClickListener { onLibroClicked(libro) }
        }
    }

    fun actualizarLibros(librosNuevos: List<Libro>) {
        libros.apply {
            clear()
            addAll(librosNuevos)
        }
        notifyDataSetChanged()
    }

    class LibrosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewAutor: TextView = itemView.findViewById(R.id.textViewAutor)
    }
}