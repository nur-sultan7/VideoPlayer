package com.nursultan.videoplayer.domain.entities

data class Video(
    val id: String,
    val fileUrl: String?,
    val smallThumbnailUrl: String?,
)