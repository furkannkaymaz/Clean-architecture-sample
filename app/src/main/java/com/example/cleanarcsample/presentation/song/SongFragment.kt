package com.example.cleanarcsample.presentation.song


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.cleanarcsample.base.BaseFragment
import com.example.cleanarcsample.databinding.FragmentSongBinding
import com.example.cleanarcsample.utils.UIStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SongFragment : BaseFragment<FragmentSongBinding, SongViewModel>() {

    override val viewModel: SongViewModel by viewModels()

    override fun viewCreated() {
        viewModel.getSongs("a",5,5)
    }

    override fun observerData() {
        super.observerData()
        viewModel.songList.observe(viewLifecycleOwner) {
            Log.d("Data",it.toString())
        }

        viewModel.state.observe(viewLifecycleOwner) {
            if (it == UIStatus.SUCCESS) {
                binding?.pb?.visibility = View.GONE
            } else {
                binding?.pb?.visibility = View.VISIBLE
            }
        }
    }


    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSongBinding {
        return FragmentSongBinding.inflate(inflater, container, false)
    }
}