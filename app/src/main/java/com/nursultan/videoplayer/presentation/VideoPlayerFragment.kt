package com.nursultan.videoplayer.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nursultan.videoplayer.databinding.FragmentVideoPlayerBinding
import javax.inject.Inject

class VideoPlayerFragment: Fragment() {
    private val binding: FragmentVideoPlayerBinding
        get() = _binding ?: throw RuntimeException("Fragment Video Player biding is null")
    private var _binding: FragmentVideoPlayerBinding? = null

    private val component by lazy {
        (requireActivity().application as VideoPlayerApp)
            .component
            .videoPlayerSubComponent()
            .create()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[VideoPlayerViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        viewModel.getVideos().observe(viewLifecycleOwner){
            Log.d("VideoPlayerFragment", it.toString())
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}