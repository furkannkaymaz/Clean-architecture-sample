package com.example.cleanarcsample.data.songs.repository

import com.example.cleanarcsample.app.di.NetworkModule
import com.example.cleanarcsample.data.network.SongApiServices
import com.example.cleanarcsample.domain.songs.repository.SongRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class SongModule {

    @Singleton
    @Provides
    fun provideSongApi(retrofit: Retrofit): SongApiServices {
        return retrofit.create(SongApiServices::class.java)
    }

    @Singleton
    @Provides
    fun provideSongRepository(songApi: SongApiServices): SongRepository {
        return SongRepositoryImp(songApi)
    }

}