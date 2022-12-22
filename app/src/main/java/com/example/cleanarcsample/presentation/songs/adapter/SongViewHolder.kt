package com.example.cleanarcsample.presentation.songs.adapter

import com.example.cleanarcsample.databinding.ItemSongBinding
import com.example.cleanarcsample.presentation.base.BaseViewHolder
import com.example.cleanarcsample.presentation.songs.ui.SongUiData
import com.example.cleanarcsample.utils.extensions.loadImage

class SongViewHolder(
    private val binding: ItemSongBinding
) : BaseViewHolder<SongUiData>(binding) {

    override fun bind(data: SongUiData, onItemClick: ((SongUiData) -> Unit)?) {
        super.bind(data, onItemClick)
        with(binding) {
            tvTitle.text = data.artistName
            ivSong.loadImage(data.artworkUrl100)

            container.setOnClickListener {
                onItemClick?.invoke(data)
            }
        }
    }
}