package com.nursultan.videoplayer.di

import android.app.Application
import com.nursultan.videoplayer.presentation.VideoPlayerApp
import dagger.BindsInstance
import dagger.Component


@Component(modules = [WorkerModule::class])
interface AppComponent {
    fun inject(app: VideoPlayerApp)
    fun videoPlayerSubComponent(): VideoPlayerComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            application: Application
        ): AppComponent
    }

}