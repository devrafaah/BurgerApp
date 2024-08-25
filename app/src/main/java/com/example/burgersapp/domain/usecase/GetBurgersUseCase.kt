package com.example.burgersapp.domain.usecase

import com.example.burgersapp.data.mapper.toDomain
import com.example.burgersapp.domain.model.Burger
import com.example.burgersapp.domain.repository.BurgerRepository
import javax.inject.Inject

class GetBurgersUseCase @Inject constructor(
    private val burgerRepository: BurgerRepository
){
    suspend operator fun invoke() : List<Burger>{
        return burgerRepository.getBurgers().map { it.toDomain() }
    }
}