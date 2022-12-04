package com.nursultan.videoplayer.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.nursultan.videoplayer.databinding.ItemVideoListDisabledBinding
import com.nursultan.videoplayer.databinding.ItemVideoListEnabledBinding
import com.nursultan.videoplayer.domain.entities.Video
import com.squareup.picasso.Picasso

class VideoListAdapter :
    ListAdapter<Video, VideoListAdapter.VideoViewHolder>(VideoItemDifCallBack()) {
    var onVideoClickListener: ((video: Video) -> Unit)? = null
    var onVideoSecondClickListener: (() -> Unit)? = null
    private var prevItemEnabledPosition: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = when (viewType) {
            ENABLED -> {
                ItemVideoListEnabledBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }
            DISABLED -> {
                ItemVideoListDisabledBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }
            else -> throw RuntimeException("View type does`t exist!")
        }
        return VideoViewHolder(binding)
    }



    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled) ENABLED else DISABLED
    }

    companion object {
        const val ENABLED = 1
        const val DISABLED = 0
    }

    class VideoViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)
    class VideoItemDifCallBack : DiffUtil.ItemCallback<Video>() {
        override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = getItem(position)
        with(holder) {
            when (binding) {
                is ItemVideoListEnabledBinding -> {
                    Picasso.get()
                        .load(video.smallPosterUrl)
                        .into(binding.ivVideoPoster)
                }
                is ItemVideoListDisabledBinding -> {
                    Picasso.get()
                        .load(video.smallPosterUrl)
                        .into(binding.ivVideoPoster)
                }
            }
            binding.root.setOnClickListener {
                if (prevItemEnabledPosition != position) {
                    prevItemEnabledPosition?.let {
                        val prevItem = getItem(it)
                        prevItem.enabled = false
                        notifyItemChanged(it)
                    }
                }
                if (video.enabled) {
                    video.enabled = false
                    prevItemEnabledPosition = null
                    onVideoSecondClickListener?.invoke()
                } else {
                    video.enabled = true
                    prevItemEnabledPosition = adapterPosition
                    onVideoClickListener?.invoke(video)
                }
                notifyItemChanged(position)
            }
        }
    }
}