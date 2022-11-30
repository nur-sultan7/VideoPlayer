package com.nursultan.videoplayer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nursultan.videoplayer.databinding.FragmentVideoPlayerBinding

class VideoPlayerFragment: Fragment() {
    private val binding: FragmentVideoPlayerBinding
        get() = _binding ?: throw RuntimeException("Fragment Video Player biding is null")
    private var _binding: FragmentVideoPlayerBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideoPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }
}