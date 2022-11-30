package com.nursultan.videoplayer.domain

import androidx.lifecycle.LiveData
import com.nursultan.videoplayer.domain.entities.Video

class GetVideosUseCase(private val repository: Repository) {
    operator fun invoke(): LiveData<List<Video>> {
        return repository.getVideos()
    }
}