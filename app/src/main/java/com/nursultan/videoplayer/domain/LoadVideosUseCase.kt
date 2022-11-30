package com.nursultan.videoplayer.domain

import javax.inject.Inject

class LoadVideosUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke() {
        repository.loadVideos()
    }
}