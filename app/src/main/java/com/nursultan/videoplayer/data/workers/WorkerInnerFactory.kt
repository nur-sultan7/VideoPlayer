package com.nursultan.videoplayer.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

interface WorkerInnerFactory {
    fun create(context: Context, workerParameters: WorkerParameters): ListenableWorker
}