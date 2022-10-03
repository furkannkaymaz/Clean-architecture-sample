package com.example.cleanarcsample.presentation.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.cleanarcsample.base.BaseFragment
import com.example.cleanarcsample.databinding.FragmentHomeBinding
import com.example.cleanarcsample.utils.UIStatus
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {


    override val viewModel: HomeViewModel by viewModels()

    override fun viewCreated() {
        viewModel.getSongs("a",5,5)
    }

    override fun observerData() {
        super.observerData()
        viewModel.compatationList.observe(viewLifecycleOwner) {
       // it.Data?.Items?.forEach {
       //     it.Items.forEach{
       //         Log.d("Teams123",it.Name)
       //     }
       // }
            Log.d("deneme",it.toString())
        Log.d("deneme",it.toString())
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
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }
}