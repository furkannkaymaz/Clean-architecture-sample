package com.example.cleanarcsample.domain.songs.di

import com.example.cleanarcsample.domain.songs.usecase.GetSongUseCase
import com.example.cleanarcsample.domain.songs.usecase.GetSongUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetSongUseCase(getSongUserCase: GetSongUseCaseImpl): GetSongUseCase
}

