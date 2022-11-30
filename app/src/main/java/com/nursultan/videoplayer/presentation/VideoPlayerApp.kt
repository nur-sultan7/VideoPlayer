package com.nursultan.videoplayer.presentation

import android.app.Application
import androidx.work.Configuration
import com.nursultan.videoplayer.data.workers.AppWorkerFactory
import com.nursultan.videoplayer.di.DaggerAppComponent
import javax.inject.Inject

class VideoPlayerApp : Application(), Configuration.Provider {
    val component by lazy {
        DaggerAppComponent.factory()
            .create(this)
    }

    @Inject
    lateinit var appWorkerFactory: AppWorkerFactory

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(appWorkerFactory)
            .build()
    }

}