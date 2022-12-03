package com.nursultan.videoplayer.di

import android.app.Application
import com.nursultan.videoplayer.presentation.VideoPlayerApp
import dagger.BindsInstance
import dagger.Component


@Component(modules = [DataModule::class, WorkerModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(app: VideoPlayerApp)
    fun videoListSubComponent(): VideoListComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            application: Application
        ): AppComponent
    }

}