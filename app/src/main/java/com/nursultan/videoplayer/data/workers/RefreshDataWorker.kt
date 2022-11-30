package com.nursultan.videoplayer.data.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.nursultan.videoplayer.data.database.VideosDao
import com.nursultan.videoplayer.data.mapper.VideoMapper
import com.nursultan.videoplayer.data.network.ApiService
import javax.inject.Inject

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val apiService: ApiService,
    private val dao: VideosDao,
    private val mapper: VideoMapper
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        val videosList = apiService.getVideos()
        dao.insertVideos(mapper.mapVideoDtoListToDbModel(videosList))
        return Result.success()
    }

    companion object {
        const val NAME = "Refresh videos data"
        fun makeRequest() = OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
    }

    class Factory @Inject constructor(
        private val apiService: ApiService,
        private val dao: VideosDao,
        private val mapper: VideoMapper
    ) : WorkerInnerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshDataWorker(context, workerParameters, apiService, dao, mapper)
        }
    }
}