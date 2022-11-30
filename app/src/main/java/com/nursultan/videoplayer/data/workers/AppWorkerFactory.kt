package com.nursultan.videoplayer.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class AppWorkerFactory @Inject constructor(
    private val workersProvider:
    @JvmSuppressWildcards Map<KClass<out ListenableWorker>, Provider<WorkerInnerFactory>>
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            RefreshDataWorker::class.qualifiedName -> {
                return workersProvider[RefreshDataWorker::class]?.get()
                    ?.create(appContext, workerParameters)
            }
            else -> null
        }
    }
}