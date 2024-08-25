package com.example.burgersapp.di

import com.example.burgersapp.data.repository.BurgerRepositoryImp
import com.example.burgersapp.domain.repository.BurgerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class DomainModule {

    @Binds
    abstract fun bindsBurgerRepositoryImp(
        burgerRepositoryImp: BurgerRepositoryImp
    ) : BurgerRepository
}