package com.example.burgersapp.data.mapper

import com.example.burgersapp.data.model.BurgerResponse
import com.example.burgersapp.data.model.ImageResponse
import com.example.burgersapp.data.model.IngredientResponse
import com.example.burgersapp.domain.model.Burger
import com.example.burgersapp.domain.model.Image
import com.example.burgersapp.domain.model.Ingredient

fun BurgerResponse.toDomain() = Burger(
    desc = this.desc,
    id = this.id,
    image = this.imageResponses?.map{ it?.toDomain() },
    ingredient = this.ingredientResponses?.map {
        it.toDomain()
    },
    name = this.name,
    price = this.price,
    veg = this.veg
)

fun ImageResponse.toDomain() = Image(
    lg = this.lg,
    sm = this.sm
)

fun IngredientResponse.toDomain() = Ingredient(
    id = this.id,
    img = this.img,
    name = this.name
)