package com.example.burgersapp.data.repository

import com.example.burgersapp.data.api.ServiceAPI
import com.example.burgersapp.data.model.BurgerResponse
import com.example.burgersapp.domain.repository.BurgerRepository
import javax.inject.Inject

class BurgerRepositoryImp @Inject constructor(
    private val serviceAPI: ServiceAPI
): BurgerRepository {

    override suspend fun getBurgers(): List<BurgerResponse> {
        return serviceAPI.getBurgers()
    }

    override suspend fun getBurgerById(burgerId: Int): BurgerResponse {
        return serviceAPI.getBurgerById(burgerId)
    }

    override suspend fun getBurgerByName(burgerName: String): List<BurgerResponse> {
        return serviceAPI.getBurgerByName(burgerName = burgerName)
    }

}