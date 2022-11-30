package com.nursultan.videoplayer.di

import com.nursultan.videoplayer.data.workers.RefreshDataWorker
import com.nursultan.videoplayer.data.workers.WorkerInnerFactory
import com.nursultan.videoplayer.di.keys.WorkerKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    @Binds
    fun bindRefreshVideoDataWorker(factory: RefreshDataWorker.Factory): WorkerInnerFactory
}