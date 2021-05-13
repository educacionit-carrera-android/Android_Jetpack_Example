package com.example.androidjetpackexample.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.example.androidjetpackexample.databinding.ActivityMainBinding
import com.example.androidjetpackexample.works.SyncLibrosWorker
import com.google.common.util.concurrent.ListenableFuture

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        programarSincronizacionLibros()
    }

    private fun programarSincronizacionLibros() {
        // Trabajo de ejecución única a partir de Builder
        /*val syncWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<SyncLibrosWorker>().build()*/

        // Trabajo de ejecución única simple
        // val syncWorkRequest = OneTimeWorkRequest.from(SyncLibrosWorker::class.java)

        // Trabajo con perioricidad
        /*val periodicWorkRequest =
            PeriodicWorkRequestBuilder<SyncLibrosWorker>(4, TimeUnit.HOURS)
                .build()*/

        // Trabajo con perioricidad y lapso de intervalo de ejecución
        /*val periodicWorkRequest = PeriodicWorkRequestBuilder<SyncLibrosWorker>(
            1, TimeUnit.HOURS, // intervalo de repetición
            15, TimeUnit.MINUTES) // lapso flexible
            .build()*/

        // Restricciones
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        // Política de Reintento - Retraso
        /*val syncWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<SyncLibrosWorker>()
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    10,
                    TimeUnit.SECONDS)
                .build()*/

        // Agregado de Tag
        /*val syncWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<SyncLibrosWorker>()
                .addTag("SyncLibros")
                .build()*/

        // Agregado de parámetors
        /*val syncWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<SyncLibrosWorker>()
                .setInputData(
                    Data.Builder()
                        .putBoolean("BORRAR_LIBROS", false)
                        .build()
                )
                .build()*/

        val syncWorkRequest: OneTimeWorkRequest =
            OneTimeWorkRequestBuilder<SyncLibrosWorker>().build()

        WorkManager
            .getInstance(this)
            .enqueueUniqueWork(
                "SyncLibros",
                ExistingWorkPolicy.KEEP,
                syncWorkRequest
            )

        /*WorkManager
            .getInstance(this)
            .enqueue(syncWorkRequest)*/

        val workManager = WorkManager.getInstance(this)

        workManager.getWorkInfoByIdLiveData(syncWorkRequest.id)
            .observe(this) { workInfo ->
                if(workInfo?.state == WorkInfo.State.SUCCEEDED) {
                    // Reaccionar a la ejecución satisfactoria
                }
            }

        // Obtener trabajo
        /*val workManager = WorkManager.getInstance(this)
        workManager.getWorkInfoById(syncWorkRequest.id)
        workManager.getWorkInfosForUniqueWork("SyncLibros")
        workManager.getWorkInfosByTag("Tag")*/

        // Detener trabajo
        /*workManager.cancelWorkById(syncWorkRequest.id)  // id
        workManager.cancelUniqueWork("sync")            // nombre
        workManager.cancelAllWorkByTag("syncTag")       // tag */
    }
}