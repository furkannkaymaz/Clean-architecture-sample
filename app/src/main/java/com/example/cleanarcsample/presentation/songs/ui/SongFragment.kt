package com.example.cleanarcsample.presentation.songs.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarcsample.R
import com.example.cleanarcsample.databinding.FragmentSongBinding
import com.example.cleanarcsample.presentation.base.BaseFragment
import com.example.cleanarcsample.presentation.songs.adapter.SongAdapter
import com.example.cleanarcsample.utils.response.UIStatus
import com.example.cleanarcsample.utils.extensions.listen
import com.example.cleanarcsample.utils.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SongFragment : BaseFragment<FragmentSongBinding, SongViewModel>() {

    override val viewModel: SongViewModel by viewModels()
    private lateinit var songAdapter : SongAdapter
    var offset = 5

    override fun observerData() {
        super.observerData()

        lifecycleScope.launch {
            viewModel.getSongs("a", offset, 5).listen {
                when (it.state) {
                    UIStatus.SUCCESS -> {
                        songAdapter.submitList(it.data)
                        configureVisibility(binding?.pb, false)
                    }
                    UIStatus.ERROR -> {
                        configureVisibility(binding?.pb, false)
                        requireActivity() toast (it.message.toString())

                    }
                    UIStatus.LOADING -> {
                        configureVisibility(binding?.pb, true)
                    }
                    else -> {
                        requireContext() toast getString(R.string.somethingWentWrong)
                    }
                }
            }
        }
    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSongBinding {
        return FragmentSongBinding.inflate(inflater, container, false)
    }

    override fun clickListeners() {
        super.clickListeners()
        binding?.btnAddMore?.setOnClickListener {
            offset += 5
            lifecycleScope.launch {
                viewModel.getSongs("a", 5,offset)
            }
        }
        binding?.btnDelete?.setOnClickListener {
            clearData()
        }
    }

    private fun clearData(){
        songAdapter.submitList(null)
        offset = 0
    }

    override fun viewCreated() {
        setAdapter()
    }

    private fun setAdapter() {

        songAdapter = SongAdapter {
            requireContext() toast it.artistName.toString()
        }

        binding?.rvSong?.adapter = songAdapter
        binding?.rvSong?.layoutManager =
            GridLayoutManager(requireContext(), 2,LinearLayoutManager.VERTICAL, false)

    }

}