package com.example.cleanarcsample.presentation.song

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarcsample.databinding.FragmentSongBinding
import com.example.cleanarcsample.presentation.base.BaseFragment
import com.example.cleanarcsample.utils.response.UIStatus
import com.example.cleanarcsample.utils.extensions.listen
import com.example.cleanarcsample.utils.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SongFragment : BaseFragment<FragmentSongBinding, SongViewModel>() {

    override val viewModel: SongViewModel by viewModels()
    private val songAdapter by lazy { SongAdapter() }

    override fun observerData() {
        super.observerData()

        lifecycleScope.launch {
            viewModel.getSongs("a", 5, 5).listen {
                when (it.state) {
                    UIStatus.SUCCESS -> {
                        songAdapter.submitList(it.data?.results)
                        configureVisibility(binding?.pb,false)

                    }
                    UIStatus.ERROR -> {
                        configureVisibility(binding?.pb,false)
                        requireActivity() toast (it.message.toString())

                    }
                    UIStatus.LOADING ->{
                        configureVisibility(binding?.pb,true)
                    }
                }
            }
        }

        binding?.btnAddMore?.setOnClickListener {
            lifecycleScope.launch {
                viewModel.getSongs("a", 10, 10).listen {
                    when (it.state) {
                        UIStatus.SUCCESS -> {
                            songAdapter.submitList(it.data?.results)
                            configureVisibility(binding?.pb,false)
                        }
                        UIStatus.ERROR -> {
                            requireActivity().toast(it.message.toString())
                            configureVisibility(binding?.pb,false)
                        }
                        UIStatus.LOADING ->{
                            configureVisibility(binding?.pb,true)
                        }
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

    override fun viewCreated() {
        setAdapter()
    }

    private fun setAdapter() {

        binding?.rvSong?.adapter = songAdapter
        binding?.rvSong?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    }

}