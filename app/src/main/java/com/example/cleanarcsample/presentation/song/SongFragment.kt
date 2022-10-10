package com.example.cleanarcsample.presentation.song


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.cleanarcsample.databinding.FragmentSongBinding
import com.example.cleanarcsample.presentation.base.BaseFragment
import com.example.cleanarcsample.utils.UIStatus
import com.example.cleanarcsample.utils.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

@AndroidEntryPoint
class SongFragment : BaseFragment<FragmentSongBinding, SongViewModel>() {

    override val viewModel: SongViewModel by viewModels()

    override fun viewCreated() {
        viewModel.getSongs("a", 5, 5)

    }

    override fun observerData() {
        super.observerData()

        viewModel.songList.observe(viewLifecycleOwner) { it ->
            when (it.state) {
                UIStatus.SUCCESS -> {
                    var value = ""

                    it?.data?.results?.forEach {
                        value += it.artistName
                        value += "\n"
                        binding?.tvSong?.text = value
                    }
                }
                UIStatus.ERROR -> {
                    requireActivity().toast(it.message.toString())
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
}