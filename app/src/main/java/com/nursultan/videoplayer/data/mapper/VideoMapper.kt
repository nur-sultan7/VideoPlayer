package com.nursultan.videoplayer.data.mapper

import com.nursultan.videoplayer.data.database.models.VideoDbModel
import com.nursultan.videoplayer.data.network.models.VideoDto
import com.nursultan.videoplayer.domain.entities.Video
import javax.inject.Inject

class VideoMapper @Inject constructor() {
    fun mapVideoDtoListToDbModel(dtoList: List<VideoDto>): List<VideoDbModel> {
        return dtoList.map {
            VideoDbModel(
                id = it.id,
                fileUrl = it.fileUrl,
                thumbnailUrl = it.thumbnailUrl,
                smallThumbnailUrl = it.smallThumbnailUrl,
                posterUrl = it.posterUrl,
                smallPosterUrl = it.smallPosterUrl
            )
        }
    }

    fun mapVideosDbModelListToEntity(modelList: List<VideoDbModel>): List<Video> {
        return modelList.map {
            Video(
                id = it.id,
                fileUrl = it.fileUrl,
                smallThumbnailUrl = it.smallThumbnailUrl,
                smallPosterUrl = it.smallPosterUrl,
                posterUrl = it.posterUrl,
            )
        }
    }
}