package com.nursultan.videoplayer.di

import com.nursultan.videoplayer.presentation.VideoPlayerFragment
import dagger.Subcomponent

@Subcomponent
interface VideoPlayerComponent {
    fun inject(fragment: VideoPlayerFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): VideoPlayerComponent
    }
}