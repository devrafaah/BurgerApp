package com.example.burgersapp.data.api

import com.example.burgersapp.data.model.BurgerResponse
import io.github.brunogabriel.mockpinterceptor.MOCK
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceAPI {


    @MOCK(asset = "burgers.json", runDelay = true)
    @GET("burgers")
    suspend fun getBurgers(): List<BurgerResponse>


    @MOCK(asset = "burger_response.json", runDelay = true)
    @GET("burgers/{burger_id}")
    suspend fun getBurgerById(
       @Path("burger_id") burgerId: Int
    ): BurgerResponse


    @MOCK(asset = "burger_search.json", runDelay = true)
    @GET("find-burger/")
    suspend fun getBurgerByName(
        @Query("searchQuery") query: String = "q",
        @Query("search") burgerName: String
    ): List<BurgerResponse>
}