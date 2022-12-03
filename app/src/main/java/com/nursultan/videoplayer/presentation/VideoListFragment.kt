package com.nursultan.videoplayer.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nursultan.videoplayer.databinding.FragmentVideoListBinding
import javax.inject.Inject

class VideoListFragment : Fragment() {
    private val binding: FragmentVideoListBinding
        get() = _binding ?: throw RuntimeException("FragmentVideoListBinding is null")
    private var _binding: FragmentVideoListBinding? = null

    private val component by lazy {
        (requireActivity().application as VideoPlayerApp)
            .component
            .videoListSubComponent()
            .create()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[VideoListViewModel::class.java]
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
        _binding = FragmentVideoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setRV()
    }

    private fun setObservers() {
        viewModel.getVideos().observe(viewLifecycleOwner) {
            Log.d("VideoPlayerFragment", it.toString())
        }
    }

    private fun setRV() {
        with(binding) {
            rvVideoList.layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}