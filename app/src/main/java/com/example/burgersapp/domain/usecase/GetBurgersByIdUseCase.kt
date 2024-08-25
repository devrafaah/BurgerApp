package com.example.burgersapp.domain.usecase

import com.example.burgersapp.data.mapper.toDomain
import com.example.burgersapp.domain.model.Burger
import com.example.burgersapp.domain.repository.BurgerRepository
import javax.inject.Inject

class GetBurgersByIdUseCase @Inject constructor(
    private val burgerRepository: BurgerRepository
){
    suspend operator fun invoke(burgerId: Int) : Burger {
        return burgerRepository.getBurgerById(burgerId).toDomain()
    }
}