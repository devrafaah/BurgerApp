package com.example.burgersapp.di

import android.content.Context
import com.example.burgersapp.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun providesServiceProvider(@ApplicationContext context: Context) = ServiceProvider(context)
}