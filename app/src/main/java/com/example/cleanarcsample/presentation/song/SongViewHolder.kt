package com.example.cleanarcsample.presentation.song

import com.example.cleanarcsample.data.songs.model.SongModelResult
import com.example.cleanarcsample.databinding.ItemSongBinding
import com.example.cleanarcsample.presentation.base.BaseViewHolder
import com.example.cleanarcsample.utils.extensions.loadImage

class SongViewHolder(
    val binding: ItemSongBinding
) : BaseViewHolder<SongModelResult>(binding) {

    override fun bind(data: SongModelResult, onItemClick: ((SongModelResult) -> Unit)?) {
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