package com.example.cleanarcsample.presentation.song


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.cleanarcsample.databinding.FragmentSongBinding
import com.example.cleanarcsample.presentation.base.BaseFragment
import com.example.cleanarcsample.utils.UIStatus
import com.example.cleanarcsample.utils.extensions.listen
import com.example.cleanarcsample.utils.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SongFragment : BaseFragment<FragmentSongBinding, SongViewModel>() {

    override val viewModel: SongViewModel by viewModels()

    override fun observerData() {
        super.observerData()

        lifecycleScope.launch {
            viewModel.getSongs("a", 5, 5).listen {
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

    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSongBinding {
        return FragmentSongBinding.inflate(inflater, container, false)
    }

    override fun viewCreated() {}
}