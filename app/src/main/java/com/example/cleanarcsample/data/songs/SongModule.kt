package com.example.cleanarcsample.data.songs

import com.example.cleanarcsample.app.di.NetworkModule
import com.example.cleanarcsample.data.network.ApiServices
import com.example.cleanarcsample.domain.song.SongRepository
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
    fun provideSongApi(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }

    @Singleton
    @Provides
    fun provideSongRepository(songApi: ApiServices): SongRepository {
        return SongRepositoryImp(songApi)
    }

}