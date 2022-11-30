package com.nursultan.videoplayer.domain

class LoadVideosUseCase(private val repository: Repository) {
    operator fun invoke() {
        repository.loadVideos()
    }
}