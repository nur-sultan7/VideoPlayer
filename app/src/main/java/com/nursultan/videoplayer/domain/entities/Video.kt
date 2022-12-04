package com.nursultan.videoplayer.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Video(
    val id: String,
    val fileUrl: String?,
    val smallThumbnailUrl: String?,
    val smallPosterUrl: String?,
    val posterUrl: String?,
    var enabled: Boolean = false
) : Parcelable