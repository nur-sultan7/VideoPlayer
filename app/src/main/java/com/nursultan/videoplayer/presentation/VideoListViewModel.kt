package com.nursultan.videoplayer.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nursultan.videoplayer.domain.GetVideosUseCase
import com.nursultan.videoplayer.domain.LoadVideosUseCase
import com.nursultan.videoplayer.domain.SetVideoEnabledUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class VideoListViewModel @Inject constructor(
    private val getVideosUseCase: GetVideosUseCase,
    private val setVideoEnabledUseCase: SetVideoEnabledUseCase,
    loadVideosUseCase: LoadVideosUseCase
) : ViewModel() {
    init {
        loadVideosUseCase.invoke()
    }

    fun getVideos() = getVideosUseCase.invoke()
    fun setVideoEnabled(id: String) {
        viewModelScope.launch {
            setVideoEnabledUseCase.invoke(id)
        }
    }
}