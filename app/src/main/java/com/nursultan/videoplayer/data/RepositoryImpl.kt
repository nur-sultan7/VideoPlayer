package com.nursultan.videoplayer.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.nursultan.videoplayer.data.database.VideosDao
import com.nursultan.videoplayer.data.mapper.VideoMapper
import com.nursultan.videoplayer.data.workers.RefreshDataWorker
import com.nursultan.videoplayer.domain.Repository
import com.nursultan.videoplayer.domain.entities.Video
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val application: Application,
    private val dao: VideosDao,
    private val mapper: VideoMapper
) : Repository {
    override fun loadVideos() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }

    override fun getVideos(): LiveData<List<Video>> {
        return Transformations.map(dao.getAllVideos()) {
            mapper.mapVideosDbModelListToEntity(it)
        }
    }
}