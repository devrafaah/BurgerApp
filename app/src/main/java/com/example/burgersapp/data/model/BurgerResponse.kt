package com.example.burgersapp.data.model

import com.google.gson.annotations.SerializedName

data class BurgerResponse(
    val desc: String?,
    val id: Int?,
    @SerializedName("images")
    val imageResponses: List<ImageResponse?>?,
    @SerializedName("ingredients")
    val ingredientResponses: List<IngredientResponse>?,
    val name: String?,
    val price: Float?,
    val veg: Boolean?
)