package com.example.androidjetpackexample.db.dao

import androidx.room.*
import com.example.androidjetpackexample.db.data.LibroEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface LibrosDao {

    // Insertar
    @Insert
    fun insertLibro(libro: LibroEntity): Completable

    @Insert
    fun insertLibros(libros: List<LibroEntity>)

    // Actualizar
    @Update
    fun actualizarLibro(libro: LibroEntity): Completable

    @Update
    fun actualizarLibros(vararg libros: LibroEntity)

    // Eliminar
    @Delete
    fun borrarLibro(libro: LibroEntity): Completable

    @Delete
    fun borrarLibros(vararg libros: LibroEntity)

    // Consultar
    @Query("SELECT * FROM libros")
    fun getLibros(): Single<List<LibroEntity>>

    @Query("SELECT nombre_libro FROM libros")
    fun getNombreLibros(): List<LibroEntity>

    @Query("SELECT * FROM libros where nombre_autor = :nombreAutor")
    fun getLibros(nombreAutor: String): List<LibroEntity>

    @Query(
        "SELECT * FROM libros where nombre_autor = :nombreAutor AND nombre_libro like :nombreLibro"
    )
    fun getLibros(nombreAutor: String, nombreLibro: String): List<LibroEntity>

    @Query("SELECT * FROM libros where nombre_autor IN (:nombresAutor)")
    fun getLibrosByAutor(nombresAutor: List<String>): List<LibroEntity>

    /*@Query(
        "SELECT * FROM libros" +
        "INNER JOIN autores ON libros.id_autor = autores.id" +
        "WHERE autores.nombre = :autor"
    )
    fun getLibrosByAutor(autor: String): List<LibroEntity>*/
}