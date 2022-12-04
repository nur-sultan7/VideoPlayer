package com.nursultan.videoplayer.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
class VideoDbModel(
    @PrimaryKey
    val id: String,
    val fileUrl: String?,
    val thumbnailUrl: String?,
    val smallThumbnailUrl: String?,
    val posterUrl: String?,
    val smallPosterUrl: String?
)