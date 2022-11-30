package com.nursultan.videoplayer.di.keys

import androidx.work.ListenableWorker
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkerKey(val kclass: KClass<out ListenableWorker>)
