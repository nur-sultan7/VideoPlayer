package com.nursultan.videoplayer.di

import android.app.Application
import com.nursultan.videoplayer.data.RepositoryImpl
import com.nursultan.videoplayer.data.database.AppDatabase
import com.nursultan.videoplayer.data.database.VideosDao
import com.nursultan.videoplayer.data.network.ApiFactory
import com.nursultan.videoplayer.data.network.ApiService
import com.nursultan.videoplayer.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @Binds
    fun bindsRepositoryImp(imp: RepositoryImpl): Repository

    companion object {
        @Provides
        fun provideVideosDao(application: Application): VideosDao {
            return AppDatabase.getInstance(application).getVideosDao()
        }

        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}