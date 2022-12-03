package com.nursultan.videoplayer.di

import androidx.lifecycle.ViewModel
import com.nursultan.videoplayer.di.keys.ViewModelKey
import com.nursultan.videoplayer.presentation.VideoListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(VideoListViewModel::class)
    @Binds
    fun bindsVideoListViewModel(videoListViewModel: VideoListViewModel): ViewModel
}