package com.example.androidjetpackexample.works

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SyncLibrosWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val borrarLibros = inputData.getBoolean("BORRAR_LIBROS", false)

        return try {
            sincronizarLibros()
            borrarLibros
            Result.success()
        } catch (exception: Exception) {
            Result.failure()
        }
    }

    private fun sincronizarLibros() {
        Log.i("SyncLibrosWorker", "SINCRONIZANDO LIBROS......")
    }
}