package com.example.cleanarcsample.presentation.songs.di

import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.domain.songs.mapper.SongListMapper
import com.example.cleanarcsample.presentation.songs.ui.SongUiData
import com.example.cleanarcsample.presentation.songs.ui.SongUiMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class SongUiMapperModule {

    @Binds
    abstract fun bindSongUiMapper(songUiMapper: SongUiMapper): SongListMapper<SongEntity, SongUiData>
}


