package com.example.burgersapp.domain.usecase

import com.example.burgersapp.data.mapper.toDomain
import com.example.burgersapp.domain.model.Burger
import com.example.burgersapp.domain.repository.BurgerRepository
import javax.inject.Inject

class GetBurgersByNameUseCase @Inject constructor(
    private val burgerRepository: BurgerRepository
){
    suspend operator fun invoke(name: String) : List<Burger>{
        return burgerRepository.getBurgerByName(name).map { it.toDomain() }.filter {
            it.name?.contains(name, ignoreCase = true) == true
        }
    }
}