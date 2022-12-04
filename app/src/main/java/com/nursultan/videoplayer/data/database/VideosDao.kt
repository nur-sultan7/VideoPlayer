package com.nursultan.videoplayer.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nursultan.videoplayer.data.database.models.VideoDbModel

@Dao
interface VideosDao {
    @Query("select * from videos")
    fun getAllVideos(): LiveData<List<VideoDbModel>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertVideos(videos: List<VideoDbModel>)
}