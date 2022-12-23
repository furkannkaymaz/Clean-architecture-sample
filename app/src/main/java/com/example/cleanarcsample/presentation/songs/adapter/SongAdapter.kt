package com.example.cleanarcsample.presentation.songs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarcsample.databinding.ItemSongBinding
import com.example.cleanarcsample.presentation.base.BaseAdapter
import com.example.cleanarcsample.presentation.songs.ui.SongUiData
import com.example.cleanarcsample.utils.adapter.getDiffUtilCallBack

class SongAdapter(
    var onClick : (SongUiData) -> Unit
) : BaseAdapter<SongUiData, RecyclerView.ViewHolder>(
    getDiffUtilCallBack()
) {

    private lateinit var bindingItemSongBinding: ItemSongBinding

    override fun bindView(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SongViewHolder).bind(currentList[position]) {
            onClick.invoke(it)
        }
    }

    override fun createView(
        context: Context,
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        bindingItemSongBinding = ItemSongBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SongViewHolder(bindingItemSongBinding)
    }
}