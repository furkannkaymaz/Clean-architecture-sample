package com.example.cleanarcsample.data.songs

import com.example.cleanarcsample.data.network.SongApiServices
import com.example.cleanarcsample.di.NetworkModule
import com.example.cleanarcsample.domain.home.SongRepository
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
    fun provideHomeApi(retrofit: Retrofit): SongApiServices {
        return retrofit.create(SongApiServices::class.java)
    }

    @Singleton
    @Provides
    fun provideHomeRepository(songApi: SongApiServices): SongRepository {
        return SongRepositoryImp(songApi)
    }

}