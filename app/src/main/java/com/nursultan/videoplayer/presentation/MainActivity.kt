package com.nursultan.videoplayer.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nursultan.videoplayer.R
import com.nursultan.videoplayer.domain.entities.Video

class MainActivity : AppCompatActivity(), VideoListFragment.VideoListItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onVideoItemClick(video: Video) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.video_container, VideoItemFragment.newInstanceVideo(video))
            .addToBackStack(null)
            .commit()
    }

    override fun onVideoItemSecondClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.video_container, VideoItemFragment.newInstanceEmpty())
            .addToBackStack(null)
            .commit()
    }
}