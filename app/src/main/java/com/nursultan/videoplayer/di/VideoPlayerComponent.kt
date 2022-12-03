package com.nursultan.videoplayer.di

import com.nursultan.videoplayer.presentation.VideoListFragment
import dagger.Subcomponent

@Subcomponent
interface VideoListComponent {
    fun inject(fragment: VideoListFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): VideoListComponent

    }
}