package com.nursultan.videoplayer.data.network

import com.nursultan.videoplayer.data.network.models.VideoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("backgrounds")
    fun getVideos(
        @Query(QUERY_GROUP) group: String = "video",
        @Query(QUERY_CATEGORY_ID) categoryId: Int = 1
    ): List<VideoDto>

    companion object {
        const val QUERY_GROUP = "group"
        const val QUERY_CATEGORY_ID = "category_id"
    }
}