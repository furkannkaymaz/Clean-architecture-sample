package com.example.cleanarcsample.data.home

import com.example.cleanarcsample.data.network.HomeApiServices
import com.example.cleanarcsample.di.NetworkModule
import com.example.cleanarcsample.domain.home.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class HomeModule {
    @Singleton
    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApiServices {
        return retrofit.create(HomeApiServices::class.java)
    }

    @Singleton
    @Provides
    fun provideHomeRepository(homeApi: HomeApiServices): HomeRepository {
        return HomeRepositoryImpl(homeApi)
    }

}