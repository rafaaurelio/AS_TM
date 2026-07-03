package com.example.as_tm.data

import com.example.as_tm.model.Meal
import com.google.gson.annotations.SerializedName

data class MealApiResponse(
    @SerializedName("meals") val meals: List<MealDto>?
)

data class MealDto(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strMealThumb") val strMealThumb: String
) {
    // Função exigida nos requisitos pra converter para a Entidade
    fun toMeal(): Meal {
        return Meal(
            id = idMeal,
            name = strMeal,
            imageUrl = strMealThumb
        )
    }
}