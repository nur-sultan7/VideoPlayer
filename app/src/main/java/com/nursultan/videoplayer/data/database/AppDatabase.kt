package com.nursultan.videoplayer.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nursultan.videoplayer.data.database.models.VideoDbModel

@Database(entities = [VideoDbModel::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var db: AppDatabase? = null
        private const val DB_NAME = "videos.db"
        private val Lock = Any()

        fun getInstance(application: Application): AppDatabase {
            db?.let {
                return it
            }
            synchronized(Lock) {
                db?.let {
                    return it
                }
                val instance = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun getVideosDao(): VideosDao
}