package com.nursultan.videoplayer.presentation

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.nursultan.videoplayer.databinding.FragmentVideoItemBinding
import com.nursultan.videoplayer.databinding.FragmentVideoItemEmptyBinding
import com.nursultan.videoplayer.domain.entities.Video
import kotlinx.parcelize.Parcelize

class VideoItemFragment : Fragment() {
    private var video: Video? = null
    private var screenMode = ScreenMode.EMPTY
    private val binding: ViewBinding
        get() = _binding ?: throw RuntimeException("VideoItemFragment binding is null!")
    private var _binding: ViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParam()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = when (screenMode) {
            ScreenMode.EMPTY ->
                FragmentVideoItemEmptyBinding.inflate(
                    inflater, container, false
                )
            ScreenMode.VIDEO ->
                FragmentVideoItemBinding.inflate(
                    inflater, container, false
                )
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchRightMode()
    }

    private fun launchRightMode() {
        when (binding) {
            is FragmentVideoItemBinding ->
                launchVideoMode(binding as FragmentVideoItemBinding)
            is FragmentVideoItemEmptyBinding ->
                launchEmptyMode()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun launchEmptyMode() {

    }

    private fun launchVideoMode(videoBinding: FragmentVideoItemBinding) {

    }

    private fun parseParam() {
        if (arguments == null)
            return
        val args = requireArguments()
        if (args.containsKey(SCREEN_MODE)) {
            screenMode =
                args.getParcelable(SCREEN_MODE) ?: throw RuntimeException("Unknown screen mode!")
        }
        if (screenMode == ScreenMode.VIDEO) {
            video = args.getParcelable(VIDEO_KEY)
        }
    }

    companion object {
        private const val SCREEN_MODE = "screen mode"
        private const val VIDEO_KEY = "video key"
        fun newInstanceEmpty() = VideoItemFragment().apply {
            arguments = Bundle().apply {
                putParcelable(SCREEN_MODE, ScreenMode.EMPTY)
            }
        }

        fun newInstanceVideo(video: Video) = VideoItemFragment().apply {
            arguments = Bundle().apply {
                putParcelable(SCREEN_MODE, ScreenMode.VIDEO)
                putParcelable(VIDEO_KEY, video)
            }
        }
    }

    @Parcelize
    enum class ScreenMode(val value: Int) : Parcelable {
        VIDEO(1), EMPTY(0)
    }
}