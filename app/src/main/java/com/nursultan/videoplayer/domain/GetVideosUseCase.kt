package com.nursultan.videoplayer.domain

import androidx.lifecycle.LiveData
import com.nursultan.videoplayer.domain.entities.Video
import javax.inject.Inject

class GetVideosUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(): LiveData<List<Video>> {
        return repository.getVideos()
    }
}