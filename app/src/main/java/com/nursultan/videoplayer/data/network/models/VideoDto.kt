package com.nursultan.videoplayer.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VideoDto(
    @SerializedName("id")
    @Expose
    val id: String? = null,

    @SerializedName("group")
    @Expose
    val group: String? = null,

    @SerializedName("color")
    @Expose
    val color: Any? = null,

    @SerializedName("file_url")
    @Expose
    val fileUrl: String? = null,

    @SerializedName("thumbnail_url")
    @Expose
    val thumbnailUrl: String? = null,

    @SerializedName("poster_url")
    @Expose
    val posterUrl: String? = null,

    @SerializedName("small_thumbnail_url")
    @Expose
    val smallThumbnailUrl: String? = null,

    @SerializedName("small_poster_url")
    @Expose
    val smallPosterUrl: String? = null,

    @SerializedName("is_favorite")
    @Expose
    val isFavorite: Boolean? = null
)