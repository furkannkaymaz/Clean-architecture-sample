package com.example.digisample.data.home

import com.example.digisample.data.network.HomeApiServices
import com.example.digisample.di.NetworkModule
import com.example.digisample.domain.home.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class HomeModule {
    @Singleton
    @Provides
    fun provideHomeApi(retrofit: Retrofit) : HomeApiServices {
        return retrofit.create(HomeApiServices::class.java)
    }

    @Singleton
    @Provides
    fun provideHomeRepository(homeApi: HomeApiServices) : HomeRepository {
        return HomeRepositoryImpl(homeApi)
    }
}