package com.example.burgersapp.domain.repository

import com.example.burgersapp.data.model.BurgerResponse

interface BurgerRepository {

    suspend fun getBurgers(): List<BurgerResponse>

    suspend fun getBurgerById(burgerId: Int): BurgerResponse

    suspend fun getBurgerByName(burgerName: String): List<BurgerResponse>

}