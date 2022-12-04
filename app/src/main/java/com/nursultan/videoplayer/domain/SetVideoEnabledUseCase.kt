package com.nursultan.videoplayer.domain

import javax.inject.Inject

class SetVideoEnabledUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(id: String){
        repository.setVideoEnabled(id)
    }
}