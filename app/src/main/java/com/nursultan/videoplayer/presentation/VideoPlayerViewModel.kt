package com.nursultan.videoplayer.presentation

import androidx.lifecycle.ViewModel
import com.nursultan.videoplayer.domain.GetVideosUseCase
import com.nursultan.videoplayer.domain.LoadVideosUseCase
import javax.inject.Inject

class VideoPlayerViewModel @Inject constructor(
    private val getVideosUseCase: GetVideosUseCase,
    private val loadVideosUseCase: LoadVideosUseCase
) : ViewModel() {
    init {
        loadVideosUseCase.invoke()
    }

    fun getVideos() = getVideosUseCase.invoke()
}