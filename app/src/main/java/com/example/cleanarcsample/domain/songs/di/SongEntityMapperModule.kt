package com.example.cleanarcsample.domain.songs.di

import com.example.cleanarcsample.data.dto.SongModelResult
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.domain.songs.mapper.SongListEntityMapper
import com.example.cleanarcsample.domain.songs.mapper.SongListMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class SongEntityMapperModule {

    @Binds
    abstract fun bindSongListEntityMapper(songListEntityMapper: SongListEntityMapper): SongListMapper<SongModelResult, SongEntity>

}


