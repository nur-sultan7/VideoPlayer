package com.nursultan.videoplayer.domain

import androidx.lifecycle.LiveData
import com.nursultan.videoplayer.domain.entities.Video

interface Repository {
    fun loadVideos()
    fun getVideos():LiveData<List<Video>>
}