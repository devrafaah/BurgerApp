package com.example.burgersapp.di

import com.example.burgersapp.data.api.ServiceAPI
import com.example.burgersapp.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun providesServicesAPI(
        serviceProvider: ServiceProvider
    ) : ServiceAPI{
        return serviceProvider.createService(
            ServiceAPI::class.java
        )
    }
}